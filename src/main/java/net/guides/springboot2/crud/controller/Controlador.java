package net.guides.springboot2.crud.controller;

import java.util.ArrayList;

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
	private ClientRepository employeeRepository;

	@RequestMapping
	public String bienvenida() {
		
		empleados = (ArrayList<Client>) employeeRepository.findAll();

		return "bienvenida";
	}

	@RequestMapping("/resultado")
	public String resultado() {

		return "resultado";
	}
	
	public static ArrayList<Client> empleados;

}
