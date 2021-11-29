package net.javaguides.springboot.service;

import net.javaguides.springboot.model.StudentClasses;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentClassesService {
    List<StudentClasses> getAllStudentClasses();
    void saveStudentClasses(StudentClasses studentClasses);
    StudentClasses getStudentClassesById(long id);
    void deleteStudentClassesById(long id);
    Page<StudentClasses> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
