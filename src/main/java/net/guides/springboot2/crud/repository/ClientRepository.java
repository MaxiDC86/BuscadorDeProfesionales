package net.guides.springboot2.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import net.guides.springboot2.crud.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	
	List<Client> findAllByZone(String zone);
	
	// List<Client> findAllByZoneAndByCity(String zone, String city);

}
