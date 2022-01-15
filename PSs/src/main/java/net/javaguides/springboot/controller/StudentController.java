package net.javaguides.springboot.controller;

import javax.validation.Valid;

import net.javaguides.springboot.model.*;
import net.javaguides.springboot.model.Class;
import net.javaguides.springboot.repository.AdressRepository;
import net.javaguides.springboot.repository.ClassRepository;
import net.javaguides.springboot.repository.SpecializationRepository;
import net.javaguides.springboot.repository.TermRepository;
import net.javaguides.springboot.service.AdressService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import net.javaguides.springboot.service.StudentService;
import net.javaguides.springboot.model.Adress;
import net.javaguides.springboot.model.domain.Degree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

	private final StudentService studentService;
	@Autowired public ClassRepository classRepository;
	@Autowired public SpecializationRepository specializationRepository;
	@Autowired public TermRepository termRepository;
	public StudentController(@Autowired StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping("/student")
	public String students(Model model){
		model.addAttribute("allStudentsFromDB", studentService.getAllStudents());

		// Kolejny widok do reenderowania, identifkator logiczny widoku do renderowania
		return "indexstudent";
	}


	@PostMapping("/addStudent")
	public String addStudent(@ModelAttribute("student") @Valid Student student,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			System.out.println("Validation error found!");
			return "new_student";
		}
		studentService.addStudent(student);

		return "redirect:/student";
	}

	@GetMapping("/student/{id}")
	public String showStudent(@PathVariable Long id, Model model){
		Student student = this.studentService.getStudentById(id);

		List<Class> studentClasses = new ArrayList<>(student.classes);
		model.addAttribute("student", student);
		model.addAttribute("studentClasses", this.classRepository.findAll());
		model.addAttribute("specializations",specializationRepository.findAll() );
		model.addAttribute("terms",termRepository.findAll() );
		System.out.println(this.classRepository.findAll());

		return "show_student";
	}

	@GetMapping("/showNewStudentForm")
	public String showNewStudentForm(Model model) {
		// create model attribute to bind form data
		Student student = new Student();


		model.addAttribute("student", student);
		model.addAttribute("degrees",Degree.values());
		model.addAttribute("classess", classRepository.findAll());
		model.addAttribute("specializations",specializationRepository.findAll() );
		model.addAttribute("terms",termRepository.findAll() );
		return "new_student";
	}
	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable long id){
		studentService.deleteStudent(id);
		return "redirect:/student";
	}
	@GetMapping("/showFormForUpdateStudent/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		Student student = studentService.getStudentById(id);

		model.addAttribute("student", student);
		model.addAttribute("degrees",Degree.values());
		model.addAttribute("classess",classRepository.findAll());
		model.addAttribute("specializations",specializationRepository.findAll() );
		model.addAttribute("terms",termRepository.findAll() );
		return "update_student";
	}

	@PostMapping("/updateStudent")
	public String updateStudent(@ModelAttribute("student") Student student){

		studentService.updateStudent(student);
		return "redirect:/student";
	}



}
