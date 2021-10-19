package com.ps.PS.service;
import java.util.List;
import com.ps.PS.model.DeansOfficeEmployee;
public interface DeansOfficeEmployeeService {
List< DeansOfficeEmployee > getAllDeansOfficeEmployees();
void saveDeansOfficeEmployee(DeansOfficeEmployee deansofficeemployee);
DeansOfficeEmployee getDeansOfficeEmployeeById(long id);
void deleteDeansOfficeEmployeeById(long id);
}
