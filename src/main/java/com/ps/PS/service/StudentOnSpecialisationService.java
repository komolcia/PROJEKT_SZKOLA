package net.javaguides.springboot.service;
import java.util.List;
import net.javaguides.springboot.model.StudentOnSpecialisation;
public interface StudentOnSpecialisationService {
List< StudentOnSpecialisation > getAllStudentOnSpecialisations();
void saveStudentOnSpecialisation(StudentOnSpecialisation studentonspecialisation);
StudentOnSpecialisation getStudentOnSpecialisationById(long id);
void deleteStudentOnSpecialisationById(long id);
}
