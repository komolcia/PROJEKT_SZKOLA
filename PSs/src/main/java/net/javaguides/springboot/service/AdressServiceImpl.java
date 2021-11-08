package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Adress;
import net.javaguides.springboot.repository.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdressServiceImpl implements AdressService {

	@Autowired
	private AdressRepository adressRepository;

	@Override
	public List<Adress> getAllAdresss() {
		return adressRepository.findAll();
	}

	@Override
	public void saveAdress(Adress adress) {
		this.adressRepository.save(adress);
	}

	@Override
	public Adress getAdressById(long id) {
		Optional<Adress> optional = adressRepository.findById(id);
		Adress adress = null;
		if (optional.isPresent()) {
			adress = optional.get();
		} else {
			throw new RuntimeException(" Adress not found for id :: " + id);
		}
		return adress;
	}

	@Override
	public void deleteAdressById(long id) {
		this.adressRepository.deleteById(id);
	}

	@Override
	public Page<Adress> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.adressRepository.findAll(pageable);
	}
}
