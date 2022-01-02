package net.javaguides.springboot.service;

import net.javaguides.springboot.model.DeansOfficeEmployee;
import net.javaguides.springboot.model.DeansOfficeEmployee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DeansOfficeEmployeeService {
	DeansOfficeEmployee addDeansOfficeEmployee(DeansOfficeEmployee deansofficeemployee);
	List<DeansOfficeEmployee> getAllDeansOfficeEmployees();
	DeansOfficeEmployee getDeansOfficeEmployeeById(long id);
	void updateDeansOfficeEmployee(DeansOfficeEmployee deansofficeemployee);
	void deleteDeansOfficeEmployee(long id);
}
