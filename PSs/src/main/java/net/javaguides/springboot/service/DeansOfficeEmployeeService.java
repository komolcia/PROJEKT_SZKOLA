package net.javaguides.springboot.service;

import net.javaguides.springboot.model.DeansOfficeEmployee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DeansOfficeEmployeeService {
	List<DeansOfficeEmployee> getAllDeansOfficeEmployees();
	void saveDeansOfficeEmployee(DeansOfficeEmployee deansofficeemployee);
	DeansOfficeEmployee getDeansOfficeEmployeeById(long id);
	void deleteDeansOfficeEmployeeById(long id);
	Page<DeansOfficeEmployee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
