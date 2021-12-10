package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;



import tn.esprit.spring.entity.Client;


public interface ClientService 
{
	List<Client> retrieveAllClients();

	Client addClient(Client c);

	void deleteClient(Long id);

	Client updateClient(Client c);

	Client retrieveClient(Long id);
	
	List<Client> retrieveClientsByDate(Date d1,Date d2);
	List<Client> retrieveClientsByDate_SQL(Date d1,Date d2);

}
