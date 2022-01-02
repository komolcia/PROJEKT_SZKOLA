package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Student;
import net.javaguides.springboot.model.StudentClasses;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentClassesService {
    StudentClasses addStudentClasses(StudentClasses studentclasses);
    List<StudentClasses> getAllStudentClassess();
    StudentClasses getStudentClassesById(long id);
    void updateStudentClasses(StudentClasses studentclasses);
    void deleteStudentClasses(long id);
}
