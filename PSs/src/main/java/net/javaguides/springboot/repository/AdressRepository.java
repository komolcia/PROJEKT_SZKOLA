package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Admin;
import net.javaguides.springboot.model.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Long>{

}
