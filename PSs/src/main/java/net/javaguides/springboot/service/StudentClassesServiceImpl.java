package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Student;
import net.javaguides.springboot.model.StudentClasses;
import net.javaguides.springboot.repository.StudentClassesRepository;
import net.javaguides.springboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentClassesServiceImpl implements StudentClassesService {
    public StudentClassesRepository studentclassesRepository;

    List<StudentClasses> lista = new ArrayList<>();
    public long id = 0;

    @Autowired
    public StudentClassesServiceImpl(StudentClassesRepository studentclassesRepository) {
        this.studentclassesRepository = studentclassesRepository;
    }

    @Override
    public List<StudentClasses> getAllStudentClassess() {
        return studentclassesRepository.findAll();
    }

    @Override
    public StudentClasses addStudentClasses(StudentClasses studentclasses) {
        return studentclassesRepository.save(studentclasses);
    }

    @Override
    public StudentClasses getStudentClassesById(long id) {
        return studentclassesRepository.getOne(id);
    }

    @Override
    public void deleteStudentClasses(long id) {
        studentclassesRepository.deleteById(id);
    }

    @Override
    public void updateStudentClasses(StudentClasses studentclasses) {
//        this.studentclassesRepository.getOne(studentclasses.getId()).setFirstName(studentclasses.getFirstName());
//        this.studentclassesRepository.getOne(studentclasses.getId()).setLastName(studentclasses.getLastName());
//        this.studentclassesRepository.getOne(studentclasses.getId()).setEmail(studentclasses.getEmail());
//        this.studentclassesRepository.getOne(studentclasses.getId()).setAdress(studentclasses.getAdress());
//        this.studentclassesRepository.getOne(studentclasses.getId()).setDegree(studentclasses.getDegree());
        this.studentclassesRepository.save(studentclasses);
    }
}
