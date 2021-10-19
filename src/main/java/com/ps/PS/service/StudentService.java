package com.ps.PS.service;
import java.util.List;
import com.ps.PS.model.Student;
public interface StudentService {
List< Student > getAllStudents();
void saveStudent(Student student);
Student getStudentById(long id);
void deleteStudentById(long id);
}
