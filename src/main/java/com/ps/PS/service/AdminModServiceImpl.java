package com.ps.PS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  com.ps.PS.model.AdminMod;
import  com.ps.PS.repository.AdminModRepository;

@Service
public class AdminModServiceImpl implements AdminModService {

    @Autowired  // it is apparently not recomended, todo: Inspect closer
    private AdminModRepository adminmodRepository;

    @Override
    public List < AdminMod > getAllAdminMods() {
        return adminmodRepository.findAll();
    }

    @Override
    public void saveAdminMod(AdminMod adminmod) {
        this.adminmodRepository.save(adminmod);
    }

    @Override
    public AdminMod getAdminModById(long id) {
        Optional < AdminMod > optional = adminmodRepository.findById(id);
        AdminMod adminmod = null;
        if (optional.isPresent()) {
            adminmod = optional.get();
        } else {
            throw new RuntimeException(" AdminMod not found for id :: " + id);
        }
        return adminmod;
    }

    @Override
    public void deleteAdminModById(long id) {
        this.adminmodRepository.deleteById(id);
    }
}
