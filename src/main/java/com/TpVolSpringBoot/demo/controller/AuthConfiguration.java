package com.TpVolSpringBoot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthConfiguration {

	@RequestMapping("/login")
	public String login(Model model) {
		return "loginform"; //renvoie vers une vue qui s'appelle "login"
	}
	
	@RequestMapping("/connexion") //URL =http://localhost:8080/demo/connexion
	public String connection() {
		return "redirect:/include/info";	
	}

}
