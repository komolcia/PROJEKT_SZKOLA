package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.StudentOnSpecialisation;

@Repository
public interface StudentOnSpecialisationRepository extends JpaRepository<StudentOnSpecialisation, Long>{

}
