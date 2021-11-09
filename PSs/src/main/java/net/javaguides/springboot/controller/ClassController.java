package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Class;
import net.javaguides.springboot.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClassController {
    @Autowired
    private ClassService ClassService;

    // display list of admins
    @GetMapping("/Class")
    public String viewHomePage(Model model) {
        return findPaginated(1, "name", "asc", model);
    }

    @GetMapping("/showNewClassForm")
    public String showNewClassForm(Model model) {
        // create model attribute to bind form data
        Class Class = new Class();
        model.addAttribute("class", Class);
        return "new_class";
    }

    @PostMapping("/saveClass")
    public String saveClass(@ModelAttribute("class") Class Class) {
        // save admin to database
        ClassService.saveClass(Class);
        return "redirect:/class";
    }

    @GetMapping("/showFormForUpdateClass/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get admin from the service
        Class Class = ClassService.getClassById(id);

        // set admin as a model attribute to pre-populate the form
        model.addAttribute("class", Class);
        return "update_class";
    }

    @GetMapping("/deleteClass/{id}")
    public String deleteClass(@PathVariable(value = "id") long id) {

        // call delete admin method
        this.ClassService.deleteClassById(id);
        return "redirect:/class";
    }


    @GetMapping("/pageClass/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Class> page = ClassService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Class> listClasses = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listClasses", listClasses);
        return "indexclass";
    }
}
