package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Professor;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProfessorService {
	List<Professor> getAllProfessors();
	void saveProfessor(Professor professor);
	Professor getProfessorById(long id);
	void deleteProfessorById(long id);
	Page<Professor> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
