package tn.esprit.spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.service.ClientServiceImpl;


@RestController
@RequestMapping("/clients")
public class ClientRestController {
	@Autowired
	
	ClientServiceImpl clientService;
	
	
	@GetMapping("/retrieve-all-clients")

	public List<Client> getAllClients() {
		List<Client> clients = clientService.retrieveAllClients();
		return clients;
	}
	
	@GetMapping("/retrieve-client/{client-id}")

		public Client retrieveClient(@PathVariable("client-id") Long clientId) {
		return clientService.retrieveClient(clientId);
	}
	
	@PostMapping("/add-client")
	
	public Client addClient(@RequestBody Client c)
	{
		Client client = clientService.addClient(c);
		return client;
	}
	
	@PutMapping("/modify-client")
	
	public Client modifyClient(@RequestBody Client client) {
	return clientService.updateClient(client);
	}
	
	@DeleteMapping("/remove-client/{client-id}")

	public void removeClient(@PathVariable("client-id") Long clientId) {
	clientService.deleteClient(clientId);
	}
	

}
