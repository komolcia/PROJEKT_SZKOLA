package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.DeansOfficeEmployee;

@Repository
public interface DeansOfficeEmployeeRepository extends JpaRepository<DeansOfficeEmployee, Long>{

}
