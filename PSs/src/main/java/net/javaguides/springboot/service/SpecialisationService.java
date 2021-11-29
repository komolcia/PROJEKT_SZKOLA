package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Specialisation;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SpecialisationService {
    List<Specialisation> getAllSpecialisations();
    void saveSpecialisation(Specialisation specialisation);
    Specialisation getSpecialisationById(long id);
    void deleteSpecialisationById(long id);
    Page<Specialisation> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}