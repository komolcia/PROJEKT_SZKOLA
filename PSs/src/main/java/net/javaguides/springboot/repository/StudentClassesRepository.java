package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.StudentClasses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentClassesRepository extends JpaRepository<StudentClasses, Long> {
}