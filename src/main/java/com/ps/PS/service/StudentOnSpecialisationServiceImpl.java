package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.StudentOnSpecialisation;
import net.javaguides.springboot.repository.StudentOnSpecialisationRepository;

@Service
public class StudentOnSpecialisationServiceImpl implements StudentOnSpecialisationService {

    @Autowired
    private StudentOnSpecialisationRepository studentonspecialisationRepository;

    @Override
    public List < StudentOnSpecialisation > getAllStudentOnSpecialisations() {
        return studentonspecialisationRepository.findAll();
    }

    @Override
    public void saveStudentOnSpecialisation(StudentOnSpecialisation studentonspecialisation) {
        this.studentonspecialisationRepository.save(studentonspecialisation);
    }

    @Override
    public StudentOnSpecialisation getStudentOnSpecialisationById(long id) {
        Optional < StudentOnSpecialisation > optional = studentonspecialisationRepository.findById(id);
        StudentOnSpecialisation studentonspecialisation = null;
        if (optional.isPresent()) {
            studentonspecialisation = optional.get();
        } else {
            throw new RuntimeException(" StudentOnSpecialisation not found for id :: " + id);
        }
        return studentonspecialisation;
    }

    @Override
    public void deleteStudentOnSpecialisationById(long id) {
        this.studentonspecialisationRepository.deleteById(id);
    }
}
