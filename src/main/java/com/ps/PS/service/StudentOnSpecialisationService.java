package com.ps.PS.service;
import java.util.List;
import com.ps.PS.model.StudentOnSpecialisation;
public interface StudentOnSpecialisationService {
List< StudentOnSpecialisation > getAllStudentOnSpecialisations();
void saveStudentOnSpecialisation(StudentOnSpecialisation studentonspecialisation);
StudentOnSpecialisation getStudentOnSpecialisationById(long id);
void deleteStudentOnSpecialisationById(long id);
}
