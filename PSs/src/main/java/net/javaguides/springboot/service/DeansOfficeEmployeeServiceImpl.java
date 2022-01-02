package net.javaguides.springboot.service;

import net.javaguides.springboot.model.DeansOfficeEmployee;
import net.javaguides.springboot.model.DeansOfficeEmployee;
import net.javaguides.springboot.repository.DeansOfficeEmployeeRepository;
import net.javaguides.springboot.repository.DeansOfficeEmployeeRepository;
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
public class DeansOfficeEmployeeServiceImpl implements DeansOfficeEmployeeService {

	public DeansOfficeEmployeeRepository deansofficeemployeeRepository;

	List<DeansOfficeEmployee> lista = new ArrayList<>();
	public long id = 0;

	@Autowired
	public DeansOfficeEmployeeServiceImpl(DeansOfficeEmployeeRepository deansofficeemployeeRepository) {
		this.deansofficeemployeeRepository = deansofficeemployeeRepository;
	}

	@Override
	public List<DeansOfficeEmployee> getAllDeansOfficeEmployees() {
		return deansofficeemployeeRepository.findAll();
	}

	@Override
	public DeansOfficeEmployee addDeansOfficeEmployee(DeansOfficeEmployee deansofficeemployee) {
		return deansofficeemployeeRepository.save(deansofficeemployee);
	}

	@Override
	public DeansOfficeEmployee getDeansOfficeEmployeeById(long id) {
		return deansofficeemployeeRepository.getOne(id);
	}

	@Override
	public void deleteDeansOfficeEmployee(long id) {
		deansofficeemployeeRepository.deleteById(id);
	}

	@Override
	public void updateDeansOfficeEmployee(DeansOfficeEmployee deansofficeemployee) {
//        this.deansofficeemployeeRepository.getOne(deansofficeemployee.getId()).setFirstName(deansofficeemployee.getFirstName());
//        this.deansofficeemployeeRepository.getOne(deansofficeemployee.getId()).setLastName(deansofficeemployee.getLastName());
//        this.deansofficeemployeeRepository.getOne(deansofficeemployee.getId()).setEmail(deansofficeemployee.getEmail());
//        this.deansofficeemployeeRepository.getOne(deansofficeemployee.getId()).setAdress(deansofficeemployee.getAdress());
//        this.deansofficeemployeeRepository.getOne(deansofficeemployee.getId()).setDegree(deansofficeemployee.getDegree());
		this.deansofficeemployeeRepository.save(deansofficeemployee);
	}
}
