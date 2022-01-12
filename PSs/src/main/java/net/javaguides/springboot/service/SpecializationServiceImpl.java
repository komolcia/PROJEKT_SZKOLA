package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Specialization;
import net.javaguides.springboot.repository.SpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecializationServiceImpl implements SpecializationService {
    @Autowired
    private SpecializationRepository specializationRepository;

    @Override
    public List<Specialization> getAllSpecializations() {
        return specializationRepository.findAll();
    }

    @Override
    public void saveSpecialization(Specialization specialization) {
        this.specializationRepository.save(specialization);
    }

    @Override
    public Specialization getSpecializationById(long id) {
        Optional<Specialization> optional = specializationRepository.findById(id);
        Specialization Specialization = null;
        if (optional.isPresent()) {
            Specialization = optional.get();
        } else {
            throw new RuntimeException(" Specialization not found for id :: " + id);
        }
        return Specialization;
    }

    @Override
    public void deleteSpecializationById(long id) {
        this.specializationRepository.deleteById(id);
    }

    @Override
    public Page<Specialization> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.specializationRepository.findAll(pageable);
    }
}
