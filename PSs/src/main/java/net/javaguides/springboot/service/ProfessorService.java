package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Professor;
import net.javaguides.springboot.model.Professor;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProfessorService {
	Professor addProfessor(Professor professor);
	List<Professor> getAllProfessors();
	Professor getProfessorById(long id);
	void updateProfessor(Professor professor);
	void deleteProfessor(long id);
}
