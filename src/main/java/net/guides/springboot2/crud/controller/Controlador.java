package net.guides.springboot2.crud.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import net.guides.springboot2.crud.model.Client;
import net.guides.springboot2.crud.model.Formulario;
import net.guides.springboot2.crud.model.Selection;
import net.guides.springboot2.crud.repository.ClientRepository;

@Controller
@RequestMapping
public class Controlador {
	public static ArrayList<Client> selectedZoneAndCityAndArea;
	public static ArrayList<Client> selectedAreaAndTypeAndZoneAndCity;
	public static ArrayList<Client> distintAreas;
	public static String selectionShowZone;
	public static String selectionShowCity;
	public static String selectionShowArea;

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
	public String procesaBusqueda(@ModelAttribute("selection") Selection selection) {

		selectedAreaAndTypeAndZoneAndCity = (ArrayList<Client>) clientRepository.findByAreaAndTypeAndZoneAndCity(
				selection.getArea(), selection.getSpecial1(), selection.getZone(), selection.getCity1());
		selectionShowCity = selection.getCity1();

		/*
		 * if (selection.getZone().equals("norte")) { selectedZoneAndCityAndArea =
		 * (ArrayList<Client>) clientRepository
		 * .findByZoneAndCityAndArea(selection.getZone(), selection.getCity1(),
		 * selection.getArea()); selectionShowCity = selection.getCity1(); } if
		 * (selection.getZone().equals("sur")) { selectedZoneAndCityAndArea =
		 * (ArrayList<Client>) clientRepository
		 * .findByZoneAndCityAndArea(selection.getZone(), selection.getCity2(),
		 * selection.getArea()); selectionShowCity = selection.getCity2(); } if
		 * (selection.getZone().equals("oeste")) { selectedZoneAndCityAndArea =
		 * (ArrayList<Client>) clientRepository
		 * .findByZoneAndCityAndArea(selection.getZone(), selection.getCity3(),
		 * selection.getArea()); selectionShowCity = selection.getCity3(); }
		 */
		selectionShowZone = selection.getZone();
		selectionShowArea = selection.getArea();
		return "resultado";
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
