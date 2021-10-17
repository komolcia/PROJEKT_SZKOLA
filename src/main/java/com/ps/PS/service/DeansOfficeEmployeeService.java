package net.javaguides.springboot.service;
import java.util.List;
import net.javaguides.springboot.model.DeansOfficeEmployee;
public interface DeansOfficeEmployeeService {
List< DeansOfficeEmployee > getAllDeansOfficeEmployees();
void saveDeansOfficeEmployee(DeansOfficeEmployee deansofficeemployee);
DeansOfficeEmployee getDeansOfficeEmployeeById(long id);
void deleteDeansOfficeEmployeeById(long id);
}
