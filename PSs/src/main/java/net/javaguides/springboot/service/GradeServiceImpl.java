package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Grade;
import net.javaguides.springboot.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {
    private GradeRepository gradeRepository;

    @Autowired
    public GradeServiceImpl(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Override
    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    @Override
    public void saveGrade(Grade grade) {
        gradeRepository.save(grade);
    }

    @Override
    public Grade getGradeById(long id) {
        return gradeRepository.getOne(id);
    }

    @Override
    public void deleteGradeById(long id) {
        gradeRepository.deleteById(id);
    }

    @Override
    public Page<Grade> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.gradeRepository.findAll(pageable);
    }
}
