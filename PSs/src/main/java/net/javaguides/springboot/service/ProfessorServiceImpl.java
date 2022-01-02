package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Professor;
import net.javaguides.springboot.model.Professor;
import net.javaguides.springboot.repository.ProfessorRepository;
import net.javaguides.springboot.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService {

	public ProfessorRepository professorRepository;

	List<Professor> lista = new ArrayList<>();
	public long id = 0;

	@Autowired
	public ProfessorServiceImpl(ProfessorRepository professorRepository) {
		this.professorRepository = professorRepository;
	}

	@Override
	public List<Professor> getAllProfessors() {
		return professorRepository.findAll();
	}

	@Override
	public Professor addProfessor(Professor professor) {
		return professorRepository.save(professor);
	}

	@Override
	public Professor getProfessorById(long id) {
		return professorRepository.getOne(id);
	}

	@Override
	public void deleteProfessor(long id) {
		professorRepository.deleteById(id);
	}

	@Override
	public void updateProfessor(Professor professor) {
//        this.professorRepository.getOne(professor.getId()).setFirstName(professor.getFirstName());
//        this.professorRepository.getOne(professor.getId()).setLastName(professor.getLastName());
//        this.professorRepository.getOne(professor.getId()).setEmail(professor.getEmail());
//        this.professorRepository.getOne(professor.getId()).setAdress(professor.getAdress());
//        this.professorRepository.getOne(professor.getId()).setDegree(professor.getDegree());
		this.professorRepository.save(professor);
	}
}
