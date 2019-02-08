package com.TpVolSpringBoot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home") //URL = http://localhost:8080/demo/home/
public class HomeController {
	
	@GetMapping({"/"})
	public String home(Model model) {
		return "/indexTest"; //Pour tester la securite --> a modifier avec le nom de la page daccueil
	}
}
