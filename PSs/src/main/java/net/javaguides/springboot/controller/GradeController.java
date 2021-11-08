package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.domain.Grade;
import net.javaguides.springboot.service.GradeService;
import net.javaguides.springboot.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class GradeController {
    @Autowired
    private GradeService gradeService;

    // display list of admins
    @GetMapping("/grade")
    public String viewHomePage(Model model) {
        return findPaginated(1, "name", "asc", model);
    }

    @GetMapping("/showNewGradeForm")
    public String showNewGradeForm(Model model) {
        // create model attribute to bind form data
        Grade grade = new Grade();
        model.addAttribute("grade", grade);
        return "new_grade";
    }

    @PostMapping("/saveGrade")
    public String saveGrade(@ModelAttribute("grade") Grade grade) {
        gradeService.saveGrade(grade);
        return "redirect:/grade";
    }

    @GetMapping("/showFormForUpdateGrade/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get admin from the service
        Grade grade = gradeService.getGradeById(id);

        // set admin as a model attribute to pre-populate the form
        model.addAttribute("grade", grade);
        return "update_grade";
    }

    @GetMapping("/deleteGrade/{id}")
    public String deleteGrade(@PathVariable(value = "id") long id) {

        // call delete admin method
        this.gradeService.deleteGradeById(id);
        return "redirect:/Grade";
    }


    @GetMapping("/pageGrade/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Grade> page = gradeService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Grade> listGrades = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listGrades", listGrades);
        return "indexGrade";
    }
}
