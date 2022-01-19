package net.guides.springboot2.crud.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import net.guides.springboot2.crud.model.Client;
import net.guides.springboot2.crud.model.Selection;
import net.guides.springboot2.crud.repository.ClientRepository;

@Controller
@RequestMapping
public class Controlador {

	@Autowired
	private ClientRepository clientRepository;

	@RequestMapping
	public String bienvenida(Model model) {

		clientes = (ArrayList<Client>) clientRepository.findAll();
		
		//selectedZoneAndCity = (ArrayList<Client>) clientRepository.findAllByZoneAndByCity("norte", "Villa Adelina");
		
		Selection selection = new Selection();

		model.addAttribute("selection", selection);

		return "bienvenida";
	}
	
	//---PROCESANDO LA BUSQUEDA-----
	
	@RequestMapping("/procesaBusqueda")
	public String procesaBusqueda(@ModelAttribute("selection") Selection selection) {
		
		selected = (ArrayList<Client>) clientRepository.findAllByZone(selection.getZone());
		
		return "resultado";
	}
	
	//----RESULTADO DE BUSQUEDA ------

	@RequestMapping("/resultado")
	public String resultado() {

		return "resultado";
	}

	public static ArrayList<Client> clientes;
	public static ArrayList<Client> selected;
	//public static ArrayList<Client> selectedZoneAndCity;

}
