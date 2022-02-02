package net.guides.springboot2.crud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.crud.exception.ResourceNotFoundException;
import net.guides.springboot2.crud.model.Client;
import net.guides.springboot2.crud.repository.ClientRepository;

@RestController
@RequestMapping("/api/v1")
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepository;

	@GetMapping("/clients")
	public List<Client> getAllEmployees() {
		return clientRepository.findAll();
	}

	@GetMapping("/clientss/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable(value = "id") Long clientId)
			throws ResourceNotFoundException {
		Client client = clientRepository.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + clientId));
		return ResponseEntity.ok().body(client);
	}

	@PostMapping("/clients")
	public Client createClient(@Valid @RequestBody Client client) {
		return clientRepository.save(client);
	}

	@PutMapping("/clients/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable(value = "id") Long clientId,
			@Valid @RequestBody Client clientDetails) throws ResourceNotFoundException {
		Client client = clientRepository.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + clientId));
		client.setViews(clientDetails.getViews());
		client.setAttention(clientDetails.getAttention());
		client.setType(clientDetails.getType());
		client.setArea(clientDetails.getArea());
		client.setCity(clientDetails.getCity());
		client.setZone(clientDetails.getZone());
		client.setTelephone(clientDetails.getTelephone());
		client.setEmailId(clientDetails.getEmailId());
		client.setLastName(clientDetails.getLastName());
		client.setFirstName(clientDetails.getFirstName());
		final Client updatedClient = clientRepository.save(client);
		return ResponseEntity.ok(updatedClient);
	}

	@DeleteMapping("/clients/{id}")
	public Map<String, Boolean> deleteClient(@PathVariable(value = "id") Long clientId)
			throws ResourceNotFoundException {
		Client client = clientRepository.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + clientId));

		clientRepository.delete(client);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
