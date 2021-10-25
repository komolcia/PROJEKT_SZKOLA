package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Admin;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AdminService {
	List<Admin> getAllAdmins();
	void saveAdmin(Admin admin);
	Admin getAdminById(long id);
	void deleteAdminById(long id);
	Page<Admin> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
