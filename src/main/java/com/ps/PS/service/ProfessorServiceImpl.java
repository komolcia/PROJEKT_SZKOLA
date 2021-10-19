package com.ps.PS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.PS.model.Professor;
import com.ps.PS.repository.ProfessorRepository;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public List < Professor > getAllProfessors() {
        return professorRepository.findAll();
    }

    @Override
    public void saveProfessor(Professor professor) {
        this.professorRepository.save(professor);
    }

    @Override
    public Professor getProfessorById(long id) {
        Optional < Professor > optional = professorRepository.findById(id);
        Professor professor = null;
        if (optional.isPresent()) {
            professor = optional.get();
        } else {
            throw new RuntimeException(" Professor not found for id :: " + id);
        }
        return professor;
    }

    @Override
    public void deleteProfessorById(long id) {
        this.professorRepository.deleteById(id);
    }
}
