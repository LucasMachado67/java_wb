package com.aula.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.aula.DAO.ContatoDao;
import com.aula.modelos.Contato;

@Controller
public class IndexController {
	
	@Autowired
	private ContatoDao cDao;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("nome", "ana");
		return "index";
	}
	
	@GetMapping("/contato")
	public String get(Model model) {		
		model.addAttribute("lista", cDao.getAll());
		return "contato";
	}
	
	@GetMapping("/novoContato")
	public String novoContato(Model model) {
		model.addAttribute("contato", new Contato());
		return "formCadContato";
	}
	
	@PostMapping("/saveContato")
	public String saveContato(@ModelAttribute Contato contato) {
		cDao.add(contato);
		return "redirect:contato";
	}
	
	
}
