package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Specialisation;
import net.javaguides.springboot.service.SpecialisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SpecialisationController {

    @Autowired
    private SpecialisationService specialisationService;

    // display list of Specialisations
    @GetMapping("/specialisation")
    public String viewHomePage(Model model) {
        return findPaginated(1, "name", "asc", model);
    }

    @GetMapping("/showNewSpecialisationForm")
    public String showNewSpecialisationForm(Model model) {
        // create model attribute to bind form data
        Specialisation Specialisation = new Specialisation();
        model.addAttribute("Specialisation", Specialisation);
        return "new_Specialisation";
    }

    @PostMapping("/saveSpecialisation")
    public String saveSpecialisation(@ModelAttribute("Specialisation") Specialisation Specialisation) {
        // save Specialisation to database
        specialisationService.saveSpecialisation(Specialisation);
        return "redirect:/Specialisation";
    }

    @GetMapping("/showFormForUpdateSpecialisation/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get Specialisation from the service
        Specialisation Specialisation = specialisationService.getSpecialisationById(id);

        // set Specialisation as a model attribute to pre-populate the form
        model.addAttribute("Specialisation", Specialisation);
        return "update_Specialisation";
    }

    @GetMapping("/deleteSpecialisation/{id}")
    public String deleteSpecialisation(@PathVariable(value = "id") long id) {

        // call delete Specialisation method 
        this.specialisationService.deleteSpecialisationById(id);
        return "redirect:/Specialisation";
    }


    @GetMapping("/pageSpecialisation/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Specialisation> page = specialisationService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Specialisation> listSpecialisations = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listSpecialisations", listSpecialisations);
        return "indexSpecialisation";
    }
}