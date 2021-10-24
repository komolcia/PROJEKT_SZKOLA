package com.ps.PS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.PS.model.Student;
import com.ps.PS.repository.StudentRepository;

//todo: https://www.tutorialspoint.com/spring_boot/spring_boot_service_components.htm I think that these stuff should be in controller (specifically the @Autowire part)

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List < Student > getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        this.studentRepository.save(student);
    }

    @Override
    public Student getStudentById(long id) {
        Optional < Student > optional = studentRepository.findById(id);
        Student student = null;
        if (optional.isPresent()) {
            student = optional.get();
        } else {
            throw new RuntimeException(" Student not found for id :: " + id);
        }
        return student;
    }

    @Override
    public void deleteStudentById(long id) {
        this.studentRepository.deleteById(id);
    }
}
