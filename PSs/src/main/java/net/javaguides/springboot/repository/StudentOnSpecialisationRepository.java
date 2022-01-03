package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.StudentClasses;
import net.javaguides.springboot.model.StudentOnSpecialisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentOnSpecialisationRepository extends JpaRepository<StudentOnSpecialisation, Long> {
}
