package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Admin;
import net.javaguides.springboot.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	// display list of admins
	@GetMapping("/admin")
	public String viewHomePage(Model model) {
		return findPaginated(1, "firstName", "asc", model);		
	}
	
	@GetMapping("/showNewAdminForm")
	public String showNewAdminForm(Model model) {
		// create model attribute to bind form data
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		return "new_admin";
	}
	
	@PostMapping("/saveAdmin")
	public String saveAdmin(@ModelAttribute("admin") Admin admin) {
		// save admin to database
		adminService.saveAdmin(admin);
		return "redirect:/admin";
	}
	
	@GetMapping("/showFormForUpdateAdmin/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get admin from the service
		Admin admin = adminService.getAdminById(id);
		
		// set admin as a model attribute to pre-populate the form
		model.addAttribute("admin", admin);
		return "update_admin";
	}
	
	@GetMapping("/deleteAdmin/{id}")
	public String deleteAdmin(@PathVariable (value = "id") long id) {
		
		// call delete admin method 
		this.adminService.deleteAdminById(id);
		return "redirect:/admin";
	}
	
	
	@GetMapping("/pageAdmin/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<Admin> page = adminService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Admin> listAdmins = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listAdmins", listAdmins);
		return "indexadmin";
	}
}
