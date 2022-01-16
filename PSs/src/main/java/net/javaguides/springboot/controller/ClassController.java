package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.*;
import net.javaguides.springboot.model.Class;
import net.javaguides.springboot.model.domain.Degree;
import net.javaguides.springboot.repository.*;
import net.javaguides.springboot.service.*;
import net.javaguides.springboot.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Class;
import net.javaguides.springboot.service.ClassService;

import javax.validation.Valid;

@Controller
public class ClassController {

    private final ClassService classService;
    @Autowired
    public AdressService adressService;
    @Autowired
    public AdressRepository adressRepository;
    @Autowired
    public ClassRepository classRepository;
    @Autowired
    public TermRepository termRepository;
    @Autowired
    public TermService termService;
    @Autowired
    public SpecializationRepository specializationRepository;

    public ClassController(@Autowired ClassService classService) {
        this.classService = classService;
    }

    @GetMapping("/class")
    public String classs(Model model){
        model.addAttribute("allClasssFromDB", classService.getAllClasses());

        if(classRepository.count()==0) {
            model.addAttribute("message",classService.getAllClasses());
        }
        // Kolejny widok do reenderowania, identifkator logiczny widoku do renderowania
        return "indexclass";
    }

    @PostMapping("/addClass")
    public String addClass(@ModelAttribute("class") @Valid Class class1, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("Validation error found!");
            return "new_class";
        }
        classService.saveClass(class1);
        return "redirect:/class";
    }

    @GetMapping("/showClassTerms/{id}")
    public String showClassTerms(@PathVariable long id, Model model) {
        Class class2 = this.classService.getClassById(id);
        StringBuilder terms = new StringBuilder();
        String specs = " ";
        try{
            for(Term term2: class2.terms){
                terms.append(term2.toString());
            }
            specs = class2.specialization.getName();
        }catch(NullPointerException ignored){
            specs = "NO SPECIALIZATION DATA";
            terms = new StringBuilder("NO TERM DATA");
        }
        model.addAttribute("termData", terms);
        model.addAttribute("specData", specs);
        model.addAttribute("class", class2);

        return "class_terms";
    }

    @GetMapping("/showNewClassForm")
    public String showNewClassForm(Model model) {
        // create model attribute to bind form data
        Class class1 = new Class();


        model.addAttribute("class", class1);
        model.addAttribute("terms", this.termRepository.findAll());
        model.addAttribute("specs", this.specializationRepository.findAll());
        return "new_class";
    }

    @GetMapping("/deleteClass/{id}")
    public String deleteClass(@PathVariable long id) {
        classService.deleteClassById(id);
        return "redirect:/class";
    }

    @GetMapping("/showFormForUpdateClass/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Class class1 = classService.getClassById(id);

        model.addAttribute("class", class1);

        return "update_class";
    }

    @PostMapping("/updateClass")
    public String updateClass(@ModelAttribute("class") Class class1) {

        classService.saveClass(class1);
        return "redirect:/class";
    }


}


