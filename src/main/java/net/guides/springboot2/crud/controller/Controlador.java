package net.guides.springboot2.crud.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import net.guides.springboot2.crud.model.Employee;
import net.guides.springboot2.crud.repository.EmployeeRepository;

@Controller
@RequestMapping
public class Controlador {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	// --WELCOME PAGE -------------

	@RequestMapping
	public String bienvenida(Model model) {

		ArrayList<Employee> clientesRegistrados = (ArrayList<Employee>) employeeRepository.findAll();

		model.addAttribute("clientesRegistrados", clientesRegistrados);

		return "bienvenida";
	}

	@RequestMapping("/resultado")
	public String resultado(@ModelAttribute("clientesRegistrados") ArrayList<Employee> clientesRegistrados) {

		return "resultado";
	}

}
