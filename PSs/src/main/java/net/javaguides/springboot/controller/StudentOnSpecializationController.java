package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.StudentOnSpecialization;
import net.javaguides.springboot.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentOnSpecializationController {
    @Autowired
    private StudentOnSpecializationService studentOnSpecializationService;

    // display list of StudentOnSpecializations
    @GetMapping("/studentOnSpecialization")
    public String viewHomePage(Model model) {
        return findPaginated(1, "id", "asc", model);
    }

    @GetMapping("/showNewStudentOnSpecializationForm")
    public String showNewStudentOnSpecializationForm(Model model) {
        // create model attribute to bind form data
        StudentOnSpecialization StudentOnSpecialization = new StudentOnSpecialization();
        model.addAttribute("studentOnSpecialization", StudentOnSpecialization);
        return "new_studentonspecialization";
    }

    @PostMapping("/saveStudentOnSpecialization")
    public String saveStudentOnSpecialization(@ModelAttribute("studentOnSpecialization") StudentOnSpecialization StudentOnSpecialization) {
        // save StudentOnSpecialization to database
        studentOnSpecializationService.saveStudentOnSpecialization(StudentOnSpecialization);
        return "redirect:/studentOnSpecialization";
    }

    @GetMapping("/showFormForUpdateStudentOnSpecialization/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get StudentOnSpecialization from the service
        StudentOnSpecialization StudentOnSpecialization = studentOnSpecializationService.getStudentOnSpecializationById(id);

        // set StudentOnSpecialization as a model attribute to pre-populate the form
        model.addAttribute("studentOnSpecialization", StudentOnSpecialization);
        return "update_studentonspecialization";
    }

    @GetMapping("/deleteStudentOnSpecialization/{id}")
    public String deleteStudentOnSpecialization(@PathVariable(value = "id") long id) {

        // call delete StudentOnSpecialization method 
        this.studentOnSpecializationService.deleteStudentOnSpecializationById(id);
        return "redirect:/studentOnSpecialization";
    }


    @GetMapping("/pageStudentOnSpecialization/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<StudentOnSpecialization> page = studentOnSpecializationService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<StudentOnSpecialization> listStudentOnSpecializations = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listStudentOnSpecializations", listStudentOnSpecializations);
        return "indexstudentonspecialization";
    }
}
