package net.javaguides.springboot.controller;


import net.javaguides.springboot.model.Student;
import net.javaguides.springboot.model.StudentClasses;
import net.javaguides.springboot.model.domain.AmountOfHours;
import net.javaguides.springboot.model.domain.Degree;
import net.javaguides.springboot.model.domain.GradeEnum;
import net.javaguides.springboot.model.domain.TypeOfClasses;
import net.javaguides.springboot.repository.*;
import net.javaguides.springboot.service.AdressService;
import net.javaguides.springboot.service.StudentClassesService;
import net.javaguides.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import net.javaguides.springboot.model.Class;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentClassesController {
    private final StudentClassesService studentclassesService;
    @Autowired public StudentRepository studentRepository;
    @Autowired public ProfessorRepository professorRepository;
    @Autowired public ClassRepository classRepository;
    public StudentClassesController(@Autowired StudentClassesService studentclassesService) {
        this.studentclassesService = studentclassesService;
    }
    @Autowired public StudentClassesRepository studentclassesRepository;
    @GetMapping("/studentclasses")
    public String studentclassess(Model model){
        model.addAttribute("allStudentClassessFromDB", studentclassesService.getAllStudentClassess());

        if(studentclassesRepository.count()==0) {
            model.addAttribute("message",studentclassesService.getAllStudentClassess());
        }
        // Kolejny widok do reenderowania, identifkator logiczny widoku do renderowania
        return "indexstudentclasses";
    }


    @PostMapping("/addStudentClasses")
    public String addStudentClasses(@ModelAttribute("studentclasses") @Valid StudentClasses studentclasses, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println("Validation error found!");
            return "new_studentclasses";
        }
        studentclassesService.addStudentClasses(studentclasses);

        return "redirect:/studentclasses";
    }



    @GetMapping("/showNewStudentClassesForm")
    public String showNewStudentClassesForm(Model model) {
        // create model attribute to bind form data
        StudentClasses studentclasses = new StudentClasses();


        model.addAttribute("studentclasses", studentclasses);
        model.addAttribute("typeofclassess", TypeOfClasses.values());
        model.addAttribute("gradeenums", GradeEnum.values());
        model.addAttribute("amountofhours", AmountOfHours.values());
        model.addAttribute("students",studentRepository.findAll() );
        model.addAttribute("professors",professorRepository.findAll() );
        model.addAttribute("classess", classRepository.findAll());
        return "new_studentclasses";
    }
    @GetMapping("/deleteStudentClasses/{id}")
    public String deleteStudentClasses(@PathVariable long id){
        studentclassesService.deleteStudentClasses(id);
        return "redirect:/studentclasses";
    }
    @GetMapping("/showFormForUpdateStudentClasses/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
        StudentClasses studentclasses = studentclassesService.getStudentClassesById(id);
        model.addAttribute("studentclasses", studentclasses);
        model.addAttribute("typeofclassess", TypeOfClasses.values());
        model.addAttribute("gradeenums", GradeEnum.values());
        model.addAttribute("amountofhourss", AmountOfHours.values());
        model.addAttribute("students",studentRepository.findAll() );
        model.addAttribute("professors",professorRepository.findAll() );
        model.addAttribute("classess", classRepository.findAll());
        return "update_studentclasses";
    }

    @PostMapping("/updateStudentClasses")
    public String updateStudentClasses(@ModelAttribute("studentclasses") StudentClasses studentclasses){

        studentclassesService.updateStudentClasses(studentclasses);
        return "redirect:/studentclasses";
    }


}
