package com.ps.PS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.PS.model.ClassesOfStudent;
import com.ps.PS.repository.ClassesOfStudentRepository;

@Service
public class ClassesOfStudentServiceImpl implements ClassesOfStudentService {

    @Autowired
    private ClassesOfStudentRepository classesofstudentRepository;

    @Override
    public List < ClassesOfStudent > getAllClassesOfStudents() {
        return classesofstudentRepository.findAll();
    }

    @Override
    public void saveClassesOfStudent(ClassesOfStudent classesofstudent) {
        this.classesofstudentRepository.save(classesofstudent);
    }

    @Override
    public ClassesOfStudent getClassesOfStudentById(long id) {
        Optional < ClassesOfStudent > optional = classesofstudentRepository.findById(id);
        ClassesOfStudent classesofstudent = null;
        if (optional.isPresent()) {
            classesofstudent = optional.get();
        } else {
            throw new RuntimeException(" ClassesOfStudent not found for id :: " + id);
        }
        return classesofstudent;
    }

    @Override
    public void deleteClassesOfStudentById(long id) {
        this.classesofstudentRepository.deleteById(id);
    }
}
