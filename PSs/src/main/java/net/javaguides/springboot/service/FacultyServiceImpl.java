package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Faculty;
import net.javaguides.springboot.model.Professor;
import net.javaguides.springboot.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    private FacultyRepository facultyRepository;
    private ProfessorService professorService;

    @Autowired
    public FacultyServiceImpl(FacultyRepository facultyRepository, ProfessorService professorService) {
        this.facultyRepository = facultyRepository;
        this.professorService = professorService;
    }

    @Override
    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    @Override
    public void saveFaculty(Faculty faculty) {
        facultyRepository.save(faculty);
    }

    @Override
    public Faculty getFacultyById(long id) {
        return facultyRepository.getOne(id);
    }

    @Override
    public void deleteFacultyById(long id) {
        facultyRepository.deleteById(id);
    }

    @Override
    public Page<Faculty> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.facultyRepository.findAll(pageable);
    }
}
