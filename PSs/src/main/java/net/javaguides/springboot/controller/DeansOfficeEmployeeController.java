package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.DeansOfficeEmployee;
import net.javaguides.springboot.service.DeansOfficeEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DeansOfficeEmployeeController {

	@Autowired
	private DeansOfficeEmployeeService deansofficeemployeeService;
	
	// display list of deansofficeemployees
	@GetMapping("/deansofficeemployee")
	public String viewHomePage(Model model) {
		return findPaginated(1, "firstName", "asc", model);		
	}
	
	@GetMapping("/showNewDeansOfficeEmployeeForm")
	public String showNewDeansOfficeEmployeeForm(Model model) {
		// create model attribute to bind form data
		DeansOfficeEmployee deansofficeemployee = new DeansOfficeEmployee();
		model.addAttribute("deansofficeemployee", deansofficeemployee);
		return "new_deansofficeemployee";
	}
	
	@PostMapping("/saveDeansOfficeEmployee")
	public String saveDeansOfficeEmployee(@ModelAttribute("deansofficeemployee") DeansOfficeEmployee deansofficeemployee) {
		// save deansofficeemployee to database
		deansofficeemployeeService.saveDeansOfficeEmployee(deansofficeemployee);
		return "redirect:/deansofficeemployee";
	}
	
	@GetMapping("/showFormForUpdateDeansOfficeEmployee/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get deansofficeemployee from the service
		DeansOfficeEmployee deansofficeemployee = deansofficeemployeeService.getDeansOfficeEmployeeById(id);
		
		// set deansofficeemployee as a model attribute to pre-populate the form
		model.addAttribute("deansofficeemployee", deansofficeemployee);
		return "update_deansofficeemployee";
	}
	
	@GetMapping("/deleteDeansOfficeEmployee/{id}")
	public String deleteDeansOfficeEmployee(@PathVariable (value = "id") long id) {
		
		// call delete deansofficeemployee method 
		this.deansofficeemployeeService.deleteDeansOfficeEmployeeById(id);
		return "redirect:/deansofficeemployee";
	}
	
	
	@GetMapping("/pageDeansOfficeEmployee/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<DeansOfficeEmployee> page = deansofficeemployeeService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<DeansOfficeEmployee> listDeansOfficeEmployees = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listDeansOfficeEmployees", listDeansOfficeEmployees);
		return "indexdeansofficeemployee";
	}
}
