package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Adress;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AdressService {
	List<Adress> getAllAdresss();
	void saveAdress(Adress adress);
	Adress getAdressById(long id);
	void deleteAdressById(long id);
	Page<Adress> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
