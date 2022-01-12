package net.javaguides.springboot.service;

import net.javaguides.springboot.model.StudentOnSpecialization;
import net.javaguides.springboot.repository.StudentOnSpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentOnSpecializationServiceImpl implements StudentOnSpecializationService {
    public StudentOnSpecializationRepository studentOnSpecializationRepository;

    @Autowired
    public StudentOnSpecializationServiceImpl(StudentOnSpecializationRepository StudentOnSpecializationRepository) {
        this.studentOnSpecializationRepository = StudentOnSpecializationRepository;
    }

    @Override
    public List<StudentOnSpecialization> getAllStudentOnSpecializations() {
        return studentOnSpecializationRepository.findAll();
    }

    @Override
    public void saveStudentOnSpecialization(StudentOnSpecialization StudentOnSpecialization) {
        studentOnSpecializationRepository.save(StudentOnSpecialization);
    }

    @Override
    public StudentOnSpecialization getStudentOnSpecializationById(long id) {
        return studentOnSpecializationRepository.getOne(id);
    }

    @Override
    public void deleteStudentOnSpecializationById(long id) {
        studentOnSpecializationRepository.deleteById(id);
    }

    @Override
    public Page<StudentOnSpecialization> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.studentOnSpecializationRepository.findAll(pageable);
    }
}
