package com.ps.PS.repository;

import com.ps.PS.model.StudentOnSpecialisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentOnSpecialisationRepository extends JpaRepository<StudentOnSpecialisation, Long>{

}
