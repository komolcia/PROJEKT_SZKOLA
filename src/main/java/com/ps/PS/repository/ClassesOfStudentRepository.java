package com.ps.PS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ps.PS.model.ClassesOfStudent;

@Repository
public interface ClassesOfStudentRepository extends JpaRepository<ClassesOfStudent, Long>{

}