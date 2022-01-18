package net.guides.springboot2.crud.controller;

import java.util.ArrayList;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controlador {

	// --WELCOME PAGE -------------

	@RequestMapping
	public String bienvenida() {

		return "bienvenida";
	}
	


}
