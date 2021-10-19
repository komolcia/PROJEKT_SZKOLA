package com.ps.PS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.PS.model.DeansOfficeEmployee;
import com.ps.PS.repository.DeansOfficeEmployeeRepository;

@Service
public class DeansOfficeEmployeeServiceImpl implements DeansOfficeEmployeeService {

    @Autowired
    private DeansOfficeEmployeeRepository deansofficeemployeeRepository;

    @Override
    public List < DeansOfficeEmployee > getAllDeansOfficeEmployees() {
        return deansofficeemployeeRepository.findAll();
    }

    @Override
    public void saveDeansOfficeEmployee(DeansOfficeEmployee deansofficeemployee) {
        this.deansofficeemployeeRepository.save(deansofficeemployee);
    }

    @Override
    public DeansOfficeEmployee getDeansOfficeEmployeeById(long id) {
        Optional < DeansOfficeEmployee > optional = deansofficeemployeeRepository.findById(id);
        DeansOfficeEmployee deansofficeemployee = null;
        if (optional.isPresent()) {
            deansofficeemployee = optional.get();
        } else {
            throw new RuntimeException(" DeansOfficeEmployee not found for id :: " + id);
        }
        return deansofficeemployee;
    }

    @Override
    public void deleteDeansOfficeEmployeeById(long id) {
        this.deansofficeemployeeRepository.deleteById(id);
    }
}
