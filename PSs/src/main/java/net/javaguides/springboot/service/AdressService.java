package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Adress;
import net.javaguides.springboot.model.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AdressService {
	List<Adress> getAllAdresss();
	Adress addAdress(Adress adress);
	Adress getAdressById(long id);
	void deleteAdress(long id);
	void updateAdress(Adress adress);
}
