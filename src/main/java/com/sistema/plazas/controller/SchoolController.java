package com.sistema.plazas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SchoolController {
	
	@GetMapping("/school")
	public String index() {
		return "school-form/school-list";
	}
	
	@GetMapping("/school/view/{id}")
	public String view(Model model, @PathVariable(name ="id")Long id) {
		return "school-form/view";
	}
	
	@GetMapping("/console/school/add")
	public String add() {
		return "school-form/add";
	}
	
	@GetMapping("/console/school/edit/{id}")
	public String edit(Model model, @PathVariable(name ="id")Long id) {
		return "school-form/edit";
	}
	
	@GetMapping("/console/school/delete/{id}")
	public String delete(Model model, @PathVariable(name ="id")Long id) {
		return "school-form/delete";
	}

}
