package net.javaguides.springboot.service;
import java.util.List;
import net.javaguides.springboot.model.ClassesOfStudent;
public interface ClassesOfStudentService {
List< ClassesOfStudent > getAllClassesOfStudents();
void saveClassesOfStudent(ClassesOfStudent classesofClassesOfClassesOfStudent);
ClassesOfStudent getClassesOfStudentById(long id);
void deleteClassesOfStudentById(long id);
}
