package net.javaguides.springboot.service;
import java.util.List;
import net.javaguides.springboot.model.Student;
public interface StudentService {
List< Student > getAllStudents();
void saveStudent(Student professor);
Student getStudentById(long id);
void deleteStudentById(long id);
}
