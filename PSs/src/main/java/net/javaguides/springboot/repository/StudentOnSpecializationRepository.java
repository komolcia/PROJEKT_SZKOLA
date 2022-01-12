package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.StudentOnSpecialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentOnSpecializationRepository extends JpaRepository<StudentOnSpecialization, Long> {
}
