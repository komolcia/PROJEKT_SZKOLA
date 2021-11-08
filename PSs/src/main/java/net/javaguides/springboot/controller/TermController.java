package net.javaguides.springboot.controller;


import net.javaguides.springboot.model.Term;
import net.javaguides.springboot.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TermController {

    @Autowired
    private TermService termService;

    // display list of terms
//    @GetMapping("/term")
//    public String viewHomePage(Model model) {
//        return findPaginated(1, "name", "asc", model);
//
//    }

    //todo: Terms can't have their "main" page because they are different for every subject, it is best if they redirect
    // later to e.g. class/terms instead of just terms/

    @GetMapping("/showNewTermForm")
    public String showNewTermForm(Model model) {
        // create model attribute to bind form data
        Term term = new Term();
        model.addAttribute("term", term);
        return "new_term";
    }

    @PostMapping("/saveTerm")
    public String saveTerm(@ModelAttribute("term") Term term) {
        // save admin to database
        termService.saveTerm(term);
        return "redirect:/term";
    }

    @GetMapping("/showFormForUpdateTerm/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get admin from the service
        Term term = termService.getTermById(id);
        // set admin as a model attribute to pre-populate the form
        model.addAttribute("term", term);
        return "update_term";
    }

    @GetMapping("/deleteTerm/{id}")
    public String deleteTerm(@PathVariable(value = "id") long id) {

        // call delete admin method
        this.termService.deleteTermById(id);
        return "redirect:/term";
    }

    @GetMapping("/pageTerm{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Term> page = termService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Term> termList = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listTerms", termList);
        return "indexterm";
    }
}