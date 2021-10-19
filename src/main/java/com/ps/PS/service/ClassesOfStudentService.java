package com.ps.PS.service;
import java.util.List;
import com.ps.PS.model.ClassesOfStudent;
public interface ClassesOfStudentService {
List< ClassesOfStudent > getAllClassesOfStudents();
void saveClassesOfStudent(ClassesOfStudent classesofClassesOfClassesOfStudent);
ClassesOfStudent getClassesOfStudentById(long id);
void deleteClassesOfStudentById(long id);
}
