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

		Selection selection = new Selection();

		model.addAttribute("selection", selection);

		return "bienvenida";
	}

	// ---PROCESANDO LA BUSQUEDA-----

	@RequestMapping("/procesaBusqueda")
	public String procesaBusqueda(@ModelAttribute("selection") Selection selection) {

		clientes = (ArrayList<Client>) clientRepository.findAll();
		if (selection.getZone().equals("norte")) {
			selectedZoneAndCity = (ArrayList<Client>) clientRepository.findByZoneAndCity(selection.getZone(),
					selection.getCity1());
			selectionShowCity = selection.getCity1();
		} else if (selection.getZone().equals("sur")) {
			selectedZoneAndCity = (ArrayList<Client>) clientRepository.findByZoneAndCity(selection.getZone(),
					selection.getCity2());
			selectionShowCity = selection.getCity2();
		} else if (selection.getZone().equals("oeste")) {
			selectedZoneAndCity = (ArrayList<Client>) clientRepository.findByZoneAndCity(selection.getZone(),
					selection.getCity3());
			selectionShowCity = selection.getCity3();
		}
		selectedZone = (ArrayList<Client>) clientRepository.findAllByZone(selection.getZone());
		// selectedCity = (ArrayList<Client>)
		// clientRepository.findAllByCity(selection.getCity());

		selectionShowZone = selection.getZone();
		// selectionShowCity = selection.getCity();

		return "resultado";
	}

	// ----RESULTADO DE BUSQUEDA ------

	@RequestMapping("/resultado")
	public String resultado() {

		return "resultado";
	}

	public static ArrayList<Client> clientes;
	public static ArrayList<Client> selectedZone;
	public static ArrayList<Client> selectedCity;
	public static ArrayList<Client> selectedZoneAndCity;
	public static String selectionShowZone;
	public static String selectionShowCity;

}
