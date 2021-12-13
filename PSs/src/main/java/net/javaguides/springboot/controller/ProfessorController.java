package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Professor;
import net.javaguides.springboot.model.domain.Degree;
import net.javaguides.springboot.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;
	
	// display list of professors
	@GetMapping("/professor")
	public String viewHomePage(Model model) {
		return findPaginated(1, "firstName", "asc", model);		
	}
	
	@GetMapping("/showNewProfessorForm")
	public String showNewProfessorForm(Model model) {
		// create model attribute to bind form data
		Professor professor = new Professor();
		model.addAttribute("professor", professor);
		model.addAttribute("degrees", Degree.values());
		return "new_professor";
	}
	
	@PostMapping("/saveProfessor")
	public String saveProfessor(@ModelAttribute("professor") Professor professor) {
		// save professor to database
		professorService.saveProfessor(professor);
		return "redirect:/professor";
	}
	
	@GetMapping("/showFormForUpdateProfessor/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get professor from the service
		Professor professor = professorService.getProfessorById(id);
		
		// set professor as a model attribute to pre-populate the form
		model.addAttribute("professor", professor);
		return "update_professor";
	}
	
	@GetMapping("/deleteProfessor/{id}")
	public String deleteProfessor(@PathVariable (value = "id") long id) {
		
		// call delete professor method 
		this.professorService.deleteProfessorById(id);
		return "redirect:/professor";
	}
	
	
	@GetMapping("/pageProfessor/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<Professor> page = professorService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Professor> listProfessors = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listProfessors", listProfessors);
		return "indexprofessor";
	}
}
