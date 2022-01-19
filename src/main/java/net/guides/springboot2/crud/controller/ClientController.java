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

	@GetMapping("/employees")
	public List<Client> getAllEmployees() {
		return clientRepository.findAll();
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Client> getEmployeeById(@PathVariable(value = "id") Long clientId)
			throws ResourceNotFoundException {
		Client client = clientRepository.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + clientId));
		return ResponseEntity.ok().body(client);
	}

	@PostMapping("/employees")
	public Client createEmployee(@Valid @RequestBody Client client) {
		return clientRepository.save(client);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Client> updateEmployee(@PathVariable(value = "id") Long clientId,
			@Valid @RequestBody Client employeeDetails) throws ResourceNotFoundException {
		Client client = clientRepository.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + clientId));
		client.setZone(employeeDetails.getZone());
		client.setTelephone(employeeDetails.getTelephone());
		client.setEmailId(employeeDetails.getEmailId());
		client.setLastName(employeeDetails.getLastName());
		client.setFirstName(employeeDetails.getFirstName());
		final Client updatedEmployee = clientRepository.save(client);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long clientId)
			throws ResourceNotFoundException {
		Client client = clientRepository.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + clientId));

		clientRepository.delete(client);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
