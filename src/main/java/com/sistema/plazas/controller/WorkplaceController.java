package com.sistema.plazas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class WorkplaceController {
	
	
	@GetMapping("/workplace")
	public String index() {
		return "workplace-form/workplace-list";
	}
	
	@GetMapping("/workplace/view/{id}")
	public String view(Model model, @PathVariable(name ="id")Long id) {
		return "workplace-form/view";
	}
	
	@GetMapping("/console/workplace/add")
	public String add() {
		return "workplace-form/add";
	}
	
	@GetMapping("/console/workplace/edit/{id}")
	public String edit(Model model, @PathVariable(name ="id")Long id) {
		return "workplace-form/edit";
	}
	
	@GetMapping("/console/workplace/delete/{id}")
	public String delete(Model model, @PathVariable(name ="id")Long id) {
		return "workplace-form/delete";
	}

}
