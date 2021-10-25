package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.DeansOfficeEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeansOfficeEmployeeRepository extends JpaRepository<DeansOfficeEmployee, Long>{

}
