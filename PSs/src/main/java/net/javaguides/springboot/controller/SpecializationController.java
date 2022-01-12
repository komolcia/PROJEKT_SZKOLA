package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Specialization;
import net.javaguides.springboot.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SpecializationController {

    @Autowired
    private SpecializationService specializationService;

    // display list of Specializations
    @GetMapping("/specialization")
    public String viewHomePage(Model model) {
        return findPaginated(1, "name", "asc", model);
    }

    @GetMapping("/showNewSpecializationForm")
    public String showNewSpecializationForm(Model model) {
        // create model attribute to bind form data
        Specialization Specialization = new Specialization();
        model.addAttribute("specialization", Specialization);
        return "new_specialization";
    }

    @PostMapping("/saveSpecialization")
    public String saveSpecialization(@ModelAttribute("Specialization") Specialization Specialization) {
        // save Specialization to database
        specializationService.saveSpecialization(Specialization);
        return "redirect:/specialization";
    }

    @GetMapping("/showFormForUpdateSpecialization/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get Specialization from the service
        Specialization Specialization = specializationService.getSpecializationById(id);

        // set Specialization as a model attribute to pre-populate the form
        model.addAttribute("specialization", Specialization);
        return "update_specialization";
    }

    @GetMapping("/deleteSpecialization/{id}")
    public String deleteSpecialization(@PathVariable(value = "id") long id) {

        // call delete Specialization method 
        this.specializationService.deleteSpecializationById(id);
        return "redirect:/specialization";
    }


    @GetMapping("/pageSpecialization/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Specialization> page = specializationService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Specialization> listSpecializations = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listSpecializations", listSpecializations);
        return "indexspecialization";
    }
}