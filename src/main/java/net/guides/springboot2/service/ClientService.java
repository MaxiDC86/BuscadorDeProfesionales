package net.guides.springboot2.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.guides.springboot2.crud.model.Client;
import net.guides.springboot2.crud.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	// ----CUSTOM QUERIES -----

	public ArrayList<Client> findAllByZone(String zone) {
		return (ArrayList<Client>) clientRepository.findAllByZone(zone);
	}

	public ArrayList<Client> findAllByCity(String city) {
		return (ArrayList<Client>) clientRepository.findAllByCity(city);
	}

	
	 public ArrayList<Client> findByZoneAndCity(String zone, String city){
	 return (ArrayList<Client>) clientRepository.findByZoneAndCity(zone,
	 city); }
	 
	 public ArrayList<Client> findByZoneAndCityAndArea(String zone, String city, String area){
		 return (ArrayList<Client>) clientRepository.findByZoneAndCityAndArea(zone,city,area);
	 }
	 
	 /*
	 public ArrayList<Client> findAllDistinctByArea(){
		 return (ArrayList<Client>) clientRepository.findAllDistinctByArea();
	 }*/
} 
