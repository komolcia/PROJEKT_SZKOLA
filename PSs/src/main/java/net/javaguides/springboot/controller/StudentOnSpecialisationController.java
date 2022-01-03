package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Class;
import net.javaguides.springboot.model.StudentOnSpecialisation;
import net.javaguides.springboot.model.domain.Degree;
import net.javaguides.springboot.repository.AdressRepository;
import net.javaguides.springboot.repository.ClassRepository;
import net.javaguides.springboot.repository.StudentClassesRepository;
import net.javaguides.springboot.service.*;
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
public class StudentOnSpecialisationController {
    @Autowired
    private StudentOnSpecialisationService studentOnSpecialisationService;

    // display list of StudentOnSpecialisations
    @GetMapping("/studentOnSpecialisation")
    public String viewHomePage(Model model) {
        return findPaginated(1, "firstName", "asc", model);
    }

    @GetMapping("/showNewStudentOnSpecialisationForm")
    public String showNewStudentOnSpecialisationForm(Model model) {
        // create model attribute to bind form data
        StudentOnSpecialisation StudentOnSpecialisation = new StudentOnSpecialisation();
        model.addAttribute("studentOnSpecialisation", StudentOnSpecialisation);
        return "new_studentonspecialisation";
    }

    @PostMapping("/saveStudentOnSpecialisation")
    public String saveStudentOnSpecialisation(@ModelAttribute("studentOnSpecialisation") StudentOnSpecialisation StudentOnSpecialisation) {
        // save StudentOnSpecialisation to database
        studentOnSpecialisationService.saveStudentOnSpecialisation(StudentOnSpecialisation);
        return "redirect:/studentOnSpecialisation";
    }

    @GetMapping("/showFormForUpdateStudentOnSpecialisation/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get StudentOnSpecialisation from the service
        StudentOnSpecialisation StudentOnSpecialisation = studentOnSpecialisationService.getStudentOnSpecialisationById(id);

        // set StudentOnSpecialisation as a model attribute to pre-populate the form
        model.addAttribute("studentOnSpecialisation", StudentOnSpecialisation);
        return "update_studentonspecialisation";
    }

    @GetMapping("/deleteStudentOnSpecialisation/{id}")
    public String deleteStudentOnSpecialisation(@PathVariable(value = "id") long id) {

        // call delete StudentOnSpecialisation method 
        this.studentOnSpecialisationService.deleteStudentOnSpecialisationById(id);
        return "redirect:/studentOnSpecialisation";
    }


    @GetMapping("/pageStudentOnSpecialisation/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<StudentOnSpecialisation> page = studentOnSpecialisationService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<StudentOnSpecialisation> listStudentOnSpecialisations = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listStudentOnSpecialisations", listStudentOnSpecialisations);
        return "indexstudentonspecialisation";
    }
}
