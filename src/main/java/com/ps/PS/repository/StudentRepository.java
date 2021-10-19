package com.ps.PS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ps.PS.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
