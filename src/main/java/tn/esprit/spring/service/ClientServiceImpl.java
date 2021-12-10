package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.Client;
import tn.esprit.spring.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	ClientRepository clientrepo;

	@Override
	public List<Client> retrieveAllClients() {
        return (List<Client>) this.clientrepo.findAll();
	}

	@Override
	public Client addClient(Client c) {
        return this.clientrepo.save(c);
	}

	@Override
	public void deleteClient(Long id) {
		clientrepo.deleteById(id);
		
	}

	@Override
	public Client updateClient(Client c) {
        Client Client = clientrepo.findById(c.getIdClient()).orElse(null);
		if(Client != null)
			clientrepo.save(c);
        return c;
	}

	@Override
	public Client retrieveClient(Long id) {
		return this.clientrepo.findById(id).orElse(null);
	}

	@Override
	public List<Client> retrieveClientsByDate(Date d1,Date d2) {
		return clientrepo.retrieveClientsByDate(d1, d2);
	}
	
	@Override
	public List<Client> retrieveClientsByDate_SQL(Date d1,Date d2) {
		return clientrepo.retrieveClientsByDate_SQL(d1, d2);
	}

}
