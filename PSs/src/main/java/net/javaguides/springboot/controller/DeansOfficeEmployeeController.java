package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Class;
import net.javaguides.springboot.model.DeansOfficeEmployee;
import net.javaguides.springboot.model.DeansOfficeEmployee;
import net.javaguides.springboot.model.domain.Degree;
import net.javaguides.springboot.repository.DeansOfficeEmployeeRepository;
import net.javaguides.springboot.repository.AdressRepository;
import net.javaguides.springboot.service.DeansOfficeEmployeeService;
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
public class DeansOfficeEmployeeController {

	@Autowired
	private DeansOfficeEmployeeService deansofficeemployeeService;
	@Autowired public AdressRepository adressRepository;

	@Autowired public DeansOfficeEmployeeRepository deansofficeemployeeRepository;
	@GetMapping("/deansofficeemployee")
	public String deansofficeemployees(Model model){
		model.addAttribute("allDeansOfficeEmployeesFromDB", deansofficeemployeeService.getAllDeansOfficeEmployees());

		if(deansofficeemployeeRepository.count()==0) {
			model.addAttribute("message",deansofficeemployeeService.getAllDeansOfficeEmployees());
		}
		// Kolejny widok do reenderowania, identifkator logiczny widoku do renderowania
		return "indexdeansofficeemployee";
	}


	@PostMapping("/addDeansOfficeEmployee")
	public String addDeansOfficeEmployee(@ModelAttribute("deansofficeemployee") @Valid DeansOfficeEmployee deansofficeemployee, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			System.out.println("Validation error found!");
			return "new_deansofficeemployee";
		}
		deansofficeemployeeService.addDeansOfficeEmployee(deansofficeemployee);

		return "redirect:/deansofficeemployee";
	}

	@GetMapping("/deansofficeemployee/{id}")
	public String showDeansOfficeEmployee(@PathVariable Long id, Model model){
		DeansOfficeEmployee deansofficeemployee = this.deansofficeemployeeService.getDeansOfficeEmployeeById(id);

		model.addAttribute("deansofficeemployee", deansofficeemployee);



		return "show_deansofficeemployee";
	}

	@GetMapping("/showNewDeansOfficeEmployeeForm")
	public String showNewDeansOfficeEmployeeForm(Model model) {
		// create model attribute to bind form data
		DeansOfficeEmployee deansofficeemployee = new DeansOfficeEmployee();


		model.addAttribute("deansofficeemployee", deansofficeemployee);
		model.addAttribute("degrees",Degree.values());
		model.addAttribute("adresses",adressRepository.findAll() );

		return "new_deansofficeemployee";
	}
	@GetMapping("/deleteDeansOfficeEmployee/{id}")
	public String deleteDeansOfficeEmployee(@PathVariable long id){
		deansofficeemployeeService.deleteDeansOfficeEmployee(id);
		return "redirect:/deansofficeemployee";
	}
	@GetMapping("/showFormForUpdateDeansOfficeEmployee/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		DeansOfficeEmployee deansofficeemployee = deansofficeemployeeService.getDeansOfficeEmployeeById(id);

		model.addAttribute("deansofficeemployee", deansofficeemployee);
		model.addAttribute("degrees",Degree.values());
		model.addAttribute("adresses",adressRepository.findAll() );

		return "update_deansofficeemployee";
	}

	@PostMapping("/updateDeansOfficeEmployee")
	public String updateDeansOfficeEmployee(@ModelAttribute("deansofficeemployee") DeansOfficeEmployee deansofficeemployee){

		deansofficeemployeeService.updateDeansOfficeEmployee(deansofficeemployee);
		return "redirect:/deansofficeemployee";
	}


}
