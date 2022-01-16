package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Faculty;
import net.javaguides.springboot.repository.ProfessorRepository;
import net.javaguides.springboot.repository.TermRepository;
import net.javaguides.springboot.service.FacultyService;
import net.javaguides.springboot.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FacultyController {

    @Autowired
    private FacultyService facultyService;
    @Autowired
    private ProfessorService professorService;
@Autowired
    public TermRepository termRepository;
@Autowired public ProfessorRepository professorRepository;
    // display list of admins
    @GetMapping("/faculty")
    public String viewHomePage(Model model) {
        return findPaginated(1, "name", "asc", model);
    }

    @GetMapping("/showNewFacultyForm")
    public String showNewFacultyForm(Model model) {
        // create model attribute to bind form data
        Faculty faculty = new Faculty();
        model.addAttribute("faculty", faculty);
        model.addAttribute("allProfessors", professorRepository.findAll());

        return "new_faculty";
    }

    @PostMapping("/saveFaculty")
    public String saveFaculty(@ModelAttribute("faculty") Faculty faculty) {
        // save admin to database
        facultyService.saveFaculty(faculty);
        return "redirect:/faculty";
    }

    @GetMapping("/showFormForUpdateFaculty/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {

        // get admin from the service
        Faculty faculty = facultyService.getFacultyById(id);

        // set admin as a model attribute to pre-populate the form
        model.addAttribute("faculty", faculty);
        model.addAttribute("allProfessors", professorRepository.findAll());

        return "update_faculty";
    }

    @GetMapping("/deleteFaculty/{id}")
    public String deleteFaculty(@PathVariable (value = "id") long id) {

        // call delete admin method
        this.facultyService.deleteFacultyById(id);
        return "redirect:/faculty";
    }


    @GetMapping("/pageFaculty/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Faculty> page = facultyService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Faculty> listFaculties = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listFaculties", listFaculties);
        return "indexfaculty";
    }
}
