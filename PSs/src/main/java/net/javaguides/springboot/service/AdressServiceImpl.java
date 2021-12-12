package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.repository.AdressRepository;
import net.javaguides.springboot.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.javaguides.springboot.model.Adress;
import net.javaguides.springboot.service.AdressService;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AdressServiceImpl implements AdressService{

	List<Adress> lista= new ArrayList<>();
	private AdressRepository adressRepository;
	@Autowired
	public AdressServiceImpl(AdressRepository adressRepository) {
		this.adressRepository = adressRepository;
	}

	public long id=0;
	@Override
	public List<Adress> getAllAdresss() {
		return adressRepository.findAll();
	}
	@Override
	public Adress addAdress(Adress adress) {

		return  this.adressRepository.save(adress);

	}
	@Override
	public Adress getAdressById(long id){
		return  adressRepository.getOne(id);
	}
	@Override
	public void deleteAdress(long id){

		this.adressRepository.deleteById((id));


	}
	@Override
	public void updateAdress(Adress adress){

		this.adressRepository.save(adress);

	}
}