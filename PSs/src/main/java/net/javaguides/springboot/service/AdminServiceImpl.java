package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Admin;
import net.javaguides.springboot.model.Admin;
import net.javaguides.springboot.repository.AdminRepository;
import net.javaguides.springboot.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
	public AdminRepository adminRepository;

	List<Admin> lista = new ArrayList<>();
	public long id = 0;

	@Autowired
	public AdminServiceImpl(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}

	@Override
	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}

	@Override
	public Admin addAdmin(Admin admin) {

		return adminRepository.save(admin);
	}

	@Override
	public Admin getAdminById(long id) {
		return adminRepository.getOne(id);
	}

	@Override
	public void deleteAdmin(long id)
	{
		adminRepository.deleteById(id);
	}

	@Override
	public void updateAdmin(Admin admin) {
//        this.adminRepository.getOne(admin.getId()).setFirstName(admin.getFirstName());
//        this.adminRepository.getOne(admin.getId()).setLastName(admin.getLastName());
//        this.adminRepository.getOne(admin.getId()).setEmail(admin.getEmail());
//        this.adminRepository.getOne(admin.getId()).setAdress(admin.getAdress());
//        this.adminRepository.getOne(admin.getId()).setDegree(admin.getDegree());
		this.adminRepository.save(admin);
	}
}
