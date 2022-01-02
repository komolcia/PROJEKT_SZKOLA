package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Admin;
import net.javaguides.springboot.model.Admin;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AdminService {
	Admin addAdmin(Admin admin);
	List<Admin> getAllAdmins();
	Admin getAdminById(long id);
	void updateAdmin(Admin admin);
	void deleteAdmin(long id);
}
