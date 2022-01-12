package net.javaguides.springboot.service;

import net.javaguides.springboot.model.StudentOnSpecialization;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentOnSpecializationService {
    List<StudentOnSpecialization> getAllStudentOnSpecializations();
    void saveStudentOnSpecialization(StudentOnSpecialization studentOnSpecialization);
    StudentOnSpecialization getStudentOnSpecializationById(long id);
    void deleteStudentOnSpecializationById(long id);
    Page<StudentOnSpecialization> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
