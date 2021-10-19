package com.ps.PS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ps.PS.model.StudentOnSpecialisation;

@Repository
public interface StudentOnSpecialisationRepository extends JpaRepository<StudentOnSpecialisation, Long>{

}
