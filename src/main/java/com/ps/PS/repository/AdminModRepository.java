package com.ps.PS.repository;

import com.ps.PS.model.AdminMod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminModRepository extends JpaRepository<AdminMod, Long>{

}
