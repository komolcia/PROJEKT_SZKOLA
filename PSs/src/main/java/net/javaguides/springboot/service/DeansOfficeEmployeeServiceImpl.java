package net.javaguides.springboot.service;

import net.javaguides.springboot.model.DeansOfficeEmployee;
import net.javaguides.springboot.repository.DeansOfficeEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeansOfficeEmployeeServiceImpl implements DeansOfficeEmployeeService {

	@Autowired
	private DeansOfficeEmployeeRepository deansofficeemployeeRepository;

	@Override
	public List<DeansOfficeEmployee> getAllDeansOfficeEmployees() {
		return deansofficeemployeeRepository.findAll();
	}

	@Override
	public void saveDeansOfficeEmployee(DeansOfficeEmployee deansofficeemployee) {
		this.deansofficeemployeeRepository.save(deansofficeemployee);
	}

	@Override
	public DeansOfficeEmployee getDeansOfficeEmployeeById(long id) {
		Optional<DeansOfficeEmployee> optional = deansofficeemployeeRepository.findById(id);
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

	@Override
	public Page<DeansOfficeEmployee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.deansofficeemployeeRepository.findAll(pageable);
	}
}
