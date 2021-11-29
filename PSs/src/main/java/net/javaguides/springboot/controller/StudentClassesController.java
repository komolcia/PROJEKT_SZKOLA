package net.javaguides.springboot.controller;


import net.javaguides.springboot.model.StudentClasses;
import net.javaguides.springboot.service.StudentClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentClassesController {
    @Autowired
    private StudentClassesService StudentClassesService;

    // display list of StudentClassess
    @GetMapping("/studentClasses")
    public String viewHomePage(Model model) {
        return findPaginated(1, "firstName", "asc", model);
    }

    @GetMapping("/showNewStudentClassesForm")
    public String showNewStudentClassesForm(Model model) {
        // create model attribute to bind form data
        StudentClasses StudentClasses = new StudentClasses();
        model.addAttribute("StudentClasses", StudentClasses);
        return "new_StudentClasses";
    }

    @PostMapping("/saveStudentClasses")
    public String saveStudentClasses(@ModelAttribute("StudentClasses") StudentClasses StudentClasses) {
        // save StudentClasses to database
        StudentClassesService.saveStudentClasses(StudentClasses);
        return "redirect:/StudentClasses";
    }

    @GetMapping("/showFormForUpdateStudentClasses/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get StudentClasses from the service
        StudentClasses StudentClasses = StudentClassesService.getStudentClassesById(id);

        // set StudentClasses as a model attribute to pre-populate the form
        model.addAttribute("StudentClasses", StudentClasses);
        return "update_StudentClasses";
    }

    @GetMapping("/deleteStudentClasses/{id}")
    public String deleteStudentClasses(@PathVariable(value = "id") long id) {

        // call delete StudentClasses method 
        this.StudentClassesService.deleteStudentClassesById(id);
        return "redirect:/StudentClasses";
    }


    @GetMapping("/pageStudentClasses/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<StudentClasses> page = StudentClassesService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<StudentClasses> listStudentClassess = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listStudentClassess", listStudentClassess);
        return "indexStudentClasses";
    }
}
