package net.guides.springboot2.crud.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import net.guides.springboot2.crud.model.Client;
import net.guides.springboot2.crud.model.ClientDetails;
import net.guides.springboot2.crud.model.Formulario;
import net.guides.springboot2.crud.model.Selection;
import net.guides.springboot2.crud.repository.ClientRepository;

@Controller
@RequestMapping
public class Controlador {
	public static ArrayList<Client> selectedCity;
	public static ArrayList<Client> selected;
	public static ArrayList<Client> distintAreas;
	public static String selectionShowZone;
	public static String selectionShowCity;
	public static String selectionShowArea;
	public static String selectionShowType;
	public static Client clientDetails;

	@Autowired
	private ClientRepository clientRepository;

	// ------WELCOME PAGE---------------
	@RequestMapping
	public String bienvenida(Model model) {
		Selection selection = new Selection();
		model.addAttribute("selection", selection);
		return "bienvenida";
	}

	// ---PROCESANDO LA BUSQUEDA-----
	@RequestMapping("/procesaBusqueda")
	public String procesaBusqueda(@ModelAttribute("selection") Selection selection,Model model) {


		
		if (selection.getSpecial1() != null) {

			selected = (ArrayList<Client>) clientRepository
					.findByAreaAndTypeAndZoneAndCityAllIgnoreCase(selection.getArea(), selection.getSpecial1(),
							selection.getZone(), selection.getCity1());
		} else {

			if (selection.getZone().equals("norte")) {
				selected = (ArrayList<Client>) clientRepository
						.findByZoneAndCityAndAreaAllIgnoreCase(selection.getZone(), selection.getCity1(), selection.getArea());
				selectionShowCity = selection.getCity1();
			}
			if (selection.getZone().equals("sur")) {
				selected = (ArrayList<Client>) clientRepository
						.findByZoneAndCityAndAreaAllIgnoreCase(selection.getZone(), selection.getCity2(), selection.getArea());
				selectionShowCity = selection.getCity2();
			}
			if (selection.getZone().equals("oeste")) {
				selected = (ArrayList<Client>) clientRepository
						.findByZoneAndCityAndAreaAllIgnoreCase(selection.getZone(), selection.getCity3(), selection.getArea());
				selectionShowCity = selection.getCity3();
			}

		}
		selectionShowZone = selection.getZone();
		selectionShowCity = (selection.getCity1()== null) ? "Todos" :selection.getCity1() ;
		selectionShowArea = selection.getArea();
		selectionShowType = (selection.getSpecial1() == null) ? "Todos" : selection.getSpecial1();
		
		ClientDetails client_id = new ClientDetails();
		model.addAttribute("client_id", client_id);
		
		return "resultado";
	}

	// ----------DETALLES DE BUSQUEDA-----------------
	@RequestMapping("/details")
	public String details(@ModelAttribute("client_id") ClientDetails client_id) {
		
     clientDetails  = clientRepository.findById(client_id.getLongId()).get();
     
     if(clientDetails.getViews()!=null) {
    	 clientDetails.setViews(clientDetails.getViews()+1); //Se suma una visita al cliente.
     }
     else {
    	 clientDetails.setViews(0);
     }
     clientRepository.save(clientDetails);
		return "details";
	}
	
	//-----TEST-------------------------
	@RequestMapping("/test")
	public String test() {
		
		//specification test
		selectedCity = (ArrayList<Client>) clientRepository.findAllByCity("Avellaneda");
		//distintAreas = (ArrayList<Client>) clientRepository.findDistintArea();
		return "test";
	}
	
	
	// ---------CONTACTO----------------------
	@RequestMapping("/contactoformulario")
	public String contactoFormulario(Model model) {
		Formulario contactoFormulario = new Formulario();
		model.addAttribute("contactoFormulario", contactoFormulario);
		return "contactoFormulario";
	}

	@RequestMapping("/enviarContactoFormulario")
	public String enviarContactoFormulario(@ModelAttribute("contactoFormulario") Formulario contactoFormulario) {
		SendMail.send(contactoFormulario);
		return "contactoFormularioEnviado";
	}

	// ----------NOSOTROS-----------------
	@RequestMapping("/nosotros")
	public String nosotros() {
		return "nosotros";
	}

}
