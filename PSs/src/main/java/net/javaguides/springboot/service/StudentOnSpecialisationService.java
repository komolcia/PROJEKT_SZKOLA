package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Specialisation;
import net.javaguides.springboot.model.StudentOnSpecialisation;
import net.javaguides.springboot.repository.StudentOnSpecialisationRepository;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentOnSpecialisationService {
    List<StudentOnSpecialisation> getAllStudentOnSpecialisations();
    void saveStudentOnSpecialisation(StudentOnSpecialisation studentOnSpecialisation);
    StudentOnSpecialisation getStudentOnSpecialisationById(long id);
    void deleteStudentOnSpecialisationById(long id);
    Page<StudentOnSpecialisation> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
