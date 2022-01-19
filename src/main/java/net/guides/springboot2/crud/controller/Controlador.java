package net.guides.springboot2.crud.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import net.guides.springboot2.crud.model.Client;
import net.guides.springboot2.crud.repository.ClientRepository;

@Controller
@RequestMapping
public class Controlador {
	
	@Autowired
	private ClientRepository clientRepository;

	@RequestMapping
	public String bienvenida() {
		
		clientes = (ArrayList<Client>) clientRepository.findAll();
		selected = (ArrayList<Client>) clientRepository.findAllByZone("norte");

		return "bienvenida";
	}

	@RequestMapping("/resultado")
	public String resultado() {

		return "resultado";
	}
	
	public static ArrayList<Client> clientes;
	public static ArrayList<Client> selected;

}
