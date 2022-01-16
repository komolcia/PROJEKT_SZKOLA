package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Class;
import net.javaguides.springboot.model.Professor;
import net.javaguides.springboot.model.Professor;
import net.javaguides.springboot.model.domain.Degree;
import net.javaguides.springboot.repository.ProfessorRepository;
import net.javaguides.springboot.repository.AdressRepository;
import net.javaguides.springboot.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;
	@Autowired public AdressRepository adressRepository;
	
	// display list of professors
	@Autowired public ProfessorRepository professorRepository;
	@GetMapping("/professor")
	public String professors(Model model){
		model.addAttribute("allProfessorsFromDB", professorService.getAllProfessors());

		if(professorRepository.count()==0) {
			model.addAttribute("message",professorService.getAllProfessors());
		}
		// Kolejny widok do reenderowania, identifkator logiczny widoku do renderowania
		return "indexprofessor";
	}


	@PostMapping("/addProfessor")
	public String addProfessor(@ModelAttribute("professor") @Valid Professor professor, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			System.out.println("Validation error found!");
			return "new_professor";
		}
		professorService.addProfessor(professor);

		return "redirect:/professor";
	}

	@GetMapping("/professor/{id}")
	public String showProfessor(@PathVariable Long id, Model model){
		Professor professor = this.professorService.getProfessorById(id);

		model.addAttribute("professor", professor);


		return "show_professor";
	}

	@GetMapping("/showNewProfessorForm")
	public String showNewProfessorForm(Model model) {
		// create model attribute to bind form data
		Professor professor = new Professor();


		model.addAttribute("professor", professor);
		model.addAttribute("degrees",Degree.values());
		model.addAttribute("adresses",adressRepository.findAll() );

		return "new_professor";
	}
	@GetMapping("/deleteProfessor/{id}")
	public String deleteProfessor(@PathVariable long id){
		professorService.deleteProfessor(id);
		return "redirect:/professor";
	}
	@GetMapping("/showFormForUpdateProfessor/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		Professor professor = professorService.getProfessorById(id);

		model.addAttribute("professor", professor);
		model.addAttribute("degrees",Degree.values());
		model.addAttribute("adresses",adressRepository.findAll() );

		return "update_professor";
	}

	@PostMapping("/updateProfessor")
	public String updateProfessor(@ModelAttribute("professor") Professor professor){

		professorService.updateProfessor(professor);
		return "redirect:/professor";
	}


}
