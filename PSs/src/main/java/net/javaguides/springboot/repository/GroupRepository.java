package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Group1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group1, Long> {
}