package net.javaguides.springboot.service;

import net.javaguides.springboot.model.StudentClasses;
import net.javaguides.springboot.repository.StudentClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentClassesServiceImpl implements StudentClassesService {
    @Autowired
    private StudentClassesRepository StudentClassesRepository;

    @Override
    public List<StudentClasses> getAllStudentClasses() {
        return StudentClassesRepository.findAll();
    }

    @Override
    public void saveStudentClasses(StudentClasses StudentClasses) {
        this.StudentClassesRepository.save(StudentClasses);
    }

    @Override
    public StudentClasses getStudentClassesById(long id) {
        Optional<StudentClasses> optional = StudentClassesRepository.findById(id);
        StudentClasses StudentClasses = null;
        if (optional.isPresent()) {
            StudentClasses = optional.get();
        } else {
            throw new RuntimeException(" StudentClasses not found for id :: " + id);
        }
        return StudentClasses;
    }

    @Override
    public void deleteStudentClassesById(long id) {
        this.StudentClassesRepository.deleteById(id);
    }

    @Override
    public Page<StudentClasses> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.StudentClassesRepository.findAll(pageable);
    }
}
