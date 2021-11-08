package net.javaguides.springboot.service;

import net.javaguides.springboot.model.domain.Grade;
import org.springframework.data.domain.Page;

import java.util.List;

public interface GradeService {
    List<Grade> getAllGrades();
    void saveGrade(Grade grade);
    Grade getGradeById(long id);
    void deleteGradeById(long id);
    Page<Grade> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
