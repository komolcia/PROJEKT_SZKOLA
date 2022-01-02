package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Admin;
import net.javaguides.springboot.model.Class;
import net.javaguides.springboot.model.Admin;
import net.javaguides.springboot.model.domain.Degree;
import net.javaguides.springboot.repository.AdressRepository;
import net.javaguides.springboot.service.AdminService;
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
public class AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired public AdressRepository adressRepository;
	@GetMapping("/admin")
	public String admins(Model model){
		model.addAttribute("allAdminsFromDB", adminService.getAllAdmins());

		// Kolejny widok do reenderowania, identifkator logiczny widoku do renderowania
		return "indexadmin";
	}

	@PostMapping("/addAdmin")
	public String addAdmin(@ModelAttribute("admin") @Valid Admin admin, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			System.out.println("Validation error found!");
			return "new_admin";
		}
		adminService.addAdmin(admin);

		return "redirect:/admin";
	}

	@GetMapping("/admin/{id}")
	public String showAdmin(@PathVariable Long id, Model model){
		Admin admin = this.adminService.getAdminById(id);

		model.addAttribute("admin", admin);


		return "show_admin";
	}

	@GetMapping("/showNewAdminForm")
	public String showNewAdminForm(Model model) {
		// create model attribute to bind form data
		Admin admin = new Admin();


		model.addAttribute("admin", admin);
		model.addAttribute("degrees", Degree.values());
		model.addAttribute("adresses",adressRepository.findAll() );

		return "new_admin";
	}
	@GetMapping("/deleteAdmin/{id}")
	public String deleteAdmin(@PathVariable long id){
		adminService.deleteAdmin(id);
		return "redirect:/admin";
	}
	@GetMapping("/showFormForUpdateAdmin/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		Admin admin = adminService.getAdminById(id);

		model.addAttribute("admin", admin);
		model.addAttribute("degrees",Degree.values());
		model.addAttribute("adresses",adressRepository.findAll() );

		return "update_admin";
	}

	@PostMapping("/updateAdmin")
	public String updateAdmin(@ModelAttribute("admin") Admin admin){

		adminService.updateAdmin(admin);
		return "redirect:/admin";
	}


}
