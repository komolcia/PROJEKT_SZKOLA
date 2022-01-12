package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Specialization;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SpecializationService {
    List<Specialization> getAllSpecializations();
    void saveSpecialization(Specialization specialization);
    Specialization getSpecializationById(long id);
    void deleteSpecializationById(long id);
    Page<Specialization> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}