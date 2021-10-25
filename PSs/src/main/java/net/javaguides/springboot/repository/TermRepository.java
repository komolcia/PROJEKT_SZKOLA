package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Term;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TermRepository extends JpaRepository<Term, Long> {
}