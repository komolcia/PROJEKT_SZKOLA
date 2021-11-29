package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Specialisation;
import net.javaguides.springboot.repository.SpecialisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialisationServiceImpl implements SpecialisationService {
    @Autowired
    private SpecialisationRepository specialisationRepository;

    @Override
    public List<Specialisation> getAllSpecialisations() {
        return specialisationRepository.findAll();
    }

    @Override
    public void saveSpecialisation(Specialisation specialisation) {
        this.specialisationRepository.save(specialisation);
    }

    @Override
    public Specialisation getSpecialisationById(long id) {
        Optional<Specialisation> optional = specialisationRepository.findById(id);
        Specialisation Specialisation = null;
        if (optional.isPresent()) {
            Specialisation = optional.get();
        } else {
            throw new RuntimeException(" Specialisation not found for id :: " + id);
        }
        return Specialisation;
    }

    @Override
    public void deleteSpecialisationById(long id) {
        this.specialisationRepository.deleteById(id);
    }

    @Override
    public Page<Specialisation> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.specialisationRepository.findAll(pageable);
    }
}
