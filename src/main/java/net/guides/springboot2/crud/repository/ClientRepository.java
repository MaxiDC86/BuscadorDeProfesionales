package net.guides.springboot2.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import net.guides.springboot2.crud.model.Client;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	
	List<Client> findAllByZone(String lastname);

}

//@EnableJpaRepositories
//class Config {}