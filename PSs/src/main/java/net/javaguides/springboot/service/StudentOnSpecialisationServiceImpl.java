package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Faculty;
import net.javaguides.springboot.model.StudentOnSpecialisation;
import net.javaguides.springboot.repository.StudentOnSpecialisationRepository;
import net.javaguides.springboot.repository.StudentOnSpecialisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentOnSpecialisationServiceImpl implements StudentOnSpecialisationService {
    public StudentOnSpecialisationRepository studentOnSpecialisationRepository;

    @Autowired
    public StudentOnSpecialisationServiceImpl(StudentOnSpecialisationRepository StudentOnSpecialisationRepository) {
        this.studentOnSpecialisationRepository = StudentOnSpecialisationRepository;
    }

    @Override
    public List<StudentOnSpecialisation> getAllStudentOnSpecialisations() {
        return studentOnSpecialisationRepository.findAll();
    }

    @Override
    public void saveStudentOnSpecialisation(StudentOnSpecialisation StudentOnSpecialisation) {
        studentOnSpecialisationRepository.save(StudentOnSpecialisation);
    }

    @Override
    public StudentOnSpecialisation getStudentOnSpecialisationById(long id) {
        return studentOnSpecialisationRepository.getOne(id);
    }

    @Override
    public void deleteStudentOnSpecialisationById(long id) {
        studentOnSpecialisationRepository.deleteById(id);
    }

    @Override
    public Page<StudentOnSpecialisation> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.studentOnSpecialisationRepository.findAll(pageable);
    }
}
