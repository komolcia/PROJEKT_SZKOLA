package com.ps.PS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ps.PS.model.DeansOfficeEmployee;

@Repository
public interface DeansOfficeEmployeeRepository extends JpaRepository<DeansOfficeEmployee, Long>{

}
