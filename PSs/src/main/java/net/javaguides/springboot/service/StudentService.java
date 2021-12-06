package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;

import net.javaguides.springboot.model.Student;

public interface StudentService {
	Student addStudent(Student student);
	List<Student> getAllStudents();
	Student getStudentById(long id);
	void updateStudent(Student student);
	void deleteStudent(long id);
}
