package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Faculty;
import org.springframework.data.domain.Page;

import java.util.List;

public interface FacultyService {
    List<Faculty> getAllFaculties();
    void saveFaculty(Faculty faculty);
    Faculty getFacultyById(long id);
    void deleteFacultyById(long id);
    Page<Faculty> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
