package com.ps.PS.service;
import java.util.List;

import com.ps.PS.model.Professor;

public interface ProfessorService {
    List<Professor> getAllProfessors();
    void saveProfessor(Professor professor);
    Professor getProfessorById(long id);
    void deleteProfessorById(long id);
}
