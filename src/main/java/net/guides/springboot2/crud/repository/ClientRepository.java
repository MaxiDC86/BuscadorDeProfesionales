package net.guides.springboot2.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import net.guides.springboot2.crud.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>, JpaSpecificationExecutor<Client>  {

	Client findById(long id);

	List<Client> findAllByZone(String zone);

	List<Client> findAllByCity(String city);

	List<Client> findByZoneAndCity(String zone, String city);

	List<Client> findByZoneAndCityAndAreaAllIgnoreCase(String zone, String city, String area);

	List<Client> findByAreaAndTypeAndZoneAndCityAllIgnoreCase(String area, String type, String zone, String city);
	
	@Query("SELECT c FROM Client c WHERE c.name LIKE %?1%")
	public List<Client> findAll(String name);
	
}
