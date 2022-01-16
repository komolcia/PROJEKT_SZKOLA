package net.javaguides.springboot.controller;


import net.javaguides.springboot.model.Student;
import net.javaguides.springboot.model.Term;
import net.javaguides.springboot.model.domain.AmountOfHours;
import net.javaguides.springboot.model.domain.Day;
import net.javaguides.springboot.model.domain.Degree;
import net.javaguides.springboot.repository.TermRepository;
import net.javaguides.springboot.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TermController {

    @Autowired
    private TermService termService;

//     display list of terms
@Autowired public TermRepository termRepository;
    @GetMapping("/term")
    public String terms(Model model){
        model.addAttribute("allTermsFromDB", termService.getAllTerms());

        if(termRepository.count()==0) {
            model.addAttribute("message",termService.getAllTerms());
        }
        // Kolejny widok do reenderowania, identifkator logiczny widoku do renderowania
        return "indexterm";
    }

    @PostMapping("/addTerm")
    public String addStudent(@ModelAttribute("term") @Valid Term term, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println("Validation error found!");
            return "new_term";
        }
        termService.saveTerm(term);
        return "redirect:/term";
    }


    @GetMapping("/showNewTermForm")
    public String showNewTermForm(Model model) {
        // create model attribute to bind form data
        Term term = new Term();
        model.addAttribute("term", term);
        model.addAttribute("amountOfHours", AmountOfHours.values());
        model.addAttribute("weeksDay", Day.values());
        return "new_term";
    }

    @PostMapping("/saveTerm")
    public String saveTerm(@ModelAttribute("term") Term term) {
        // save term to database
        termService.saveTerm(term);
        return "redirect:/term";
    }

    @GetMapping("/showFormForUpdateTerm/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get term from the service
        Term term = termService.getTermById(id);
        // set term as a model attribute to pre-populate the form
        model.addAttribute("term", term);
        return "update_term";
    }

    @GetMapping("/deleteTerm/{id}")
    public String deleteTerm(@PathVariable(value = "id") long id) {

        // call delete term method
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
