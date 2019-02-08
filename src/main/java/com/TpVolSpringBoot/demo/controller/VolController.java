package com.TpVolSpringBoot.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TpVolSpringBoot.demo.entity.Vol;
import com.TpVolSpringBoot.demo.repository.AeroportRepository;
import com.TpVolSpringBoot.demo.repository.ReservationRepository;
import com.TpVolSpringBoot.demo.repository.VolRepository;

@Controller
@RequestMapping("/vol") // URL = http://localhost:8080/TpVolMvc/vol/list
public class VolController {

	@Autowired
	private VolRepository volRepository;
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private AeroportRepository aeroportRepository;
	
	@GetMapping(value= {"/","/list"}) // ce qu'on rentre dans l'url
	public String list(Model model) {
		model.addAttribute("vol", volRepository.findAll());
		model.addAttribute("repovol", volRepository);
		return "Vol/listVols"; // chemin de la page qu'il doit retourner
	}
	
	@GetMapping("/rechercheVol")
	public String rechercheVol(Model model) {
		model.addAttribute("aeroport", aeroportRepository.findAll());
		model.addAttribute("vol", new Vol());
		return "Vol/RechercheVol";
	}
	
	@GetMapping("/afficherRechercheVol")
	public String afficherRechercheVol(@RequestParam(name="aeroportArrivee.id", required=true) Long idAeroportArrivee, @RequestParam(name="aeroportDepart.id", required=true) Long idAeroportDepart, Model model){
		model.addAttribute("vol", volRepository.findWithAeroportArriveeDepart(aeroportRepository.findById(idAeroportArrivee).get(), aeroportRepository.findById(idAeroportDepart).get()).get());
		model.addAttribute("repovol", volRepository);
		System.out.println("yopyopyopyopyopyopyopyopyopypoyopypoypyopyopoypo");
		
		System.out.println(volRepository.findWithAeroportArriveeDepart(aeroportRepository.findById(idAeroportArrivee).get(), aeroportRepository.findById(idAeroportDepart).get()));
		return "Vol/listVols";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam(name="id", required=true) Long id) {
		volRepository.deleteById(id);
		return "redirect:/vol/list";	// redirect -> r��criture de l'url
	}
	
	@GetMapping("/addVol")
	public String addVol(Model model) {
		return goEdit(new Vol(), model);
	}
	
	
	@GetMapping("/edit")
	public String edit(@RequestParam(name="id", required=true)Long id,Model model) {
		Vol vol = volRepository.findById(id).get();
		return goEdit(vol, model);
	}
	
	private String goEdit(Vol vol, Model model) {
		model.addAttribute("vol", vol);
		model.addAttribute("aeroport", aeroportRepository.findAll());
		System.out.println(aeroportRepository.findAll());
		return "Vol/EditVol";
	}
	
	@GetMapping("/save")
	public String save(@Valid @ModelAttribute("vol") Vol vol, BindingResult br, Model model) {
		if(br.hasErrors()) {
			//System.out.println("----------------------------------------------------------------");
			//System.out.println(br.getFieldError());
			return "Vol/EditVol";
	}else {
		volRepository.save(vol);
	}
	return "redirect:/vol/list";
}

}
