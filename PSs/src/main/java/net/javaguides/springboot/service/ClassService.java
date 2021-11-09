package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Class;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ClassService {
    List<Class> getAllClasses();

    void saveClass(Class Class);

    Class getClassById(long id);

    void deleteClassById(long id);

    Page<Class> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
