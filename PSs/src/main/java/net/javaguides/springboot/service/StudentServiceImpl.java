package net.javaguides.springboot.service;

import java.util.*;

import net.javaguides.springboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.javaguides.springboot.model.Student;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    public StudentRepository studentRepository;

    List<Student> lista = new ArrayList<>();
    public long id = 0;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(long id) {
        return studentRepository.getOne(id);
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void updateStudent(Student student) {
//        this.studentRepository.getOne(student.getId()).setFirstName(student.getFirstName());
//        this.studentRepository.getOne(student.getId()).setLastName(student.getLastName());
//        this.studentRepository.getOne(student.getId()).setEmail(student.getEmail());
//        this.studentRepository.getOne(student.getId()).setAdress(student.getAdress());
//        this.studentRepository.getOne(student.getId()).setDegree(student.getDegree());
        this.studentRepository.save(student);
    }
}
