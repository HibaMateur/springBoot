package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.repository.ReclamationRepository;


@Service
public class reclamationServiceImpl implements reclamationService{
	@Autowired
	ReclamationRepository Reclamationrepo;
	@Autowired
	ClientService clientService;

	@Override
	public List<Reclamation> retrieveAllReclamations() {
		return (List<Reclamation>) this.Reclamationrepo.findAll();
	}
	
	@Override
	public Reclamation addReclamation(Reclamation r) {
		//r.setClientReclamation(clientService.retrieveClient(r.getClientReclamation().getIdClient()));
        return this.Reclamationrepo.save(r);
	}
	@Override
	public void deleteReclamation(Long id) {
		Reclamationrepo.deleteById(id);
		
	}

	@Override
	public Reclamation updateReclamation(Reclamation r) {
		Reclamation reclamation = Reclamationrepo.findById(r.getIdReclamation()).orElse(null);
		if(reclamation != null)
			Reclamationrepo.save(r);
        return r;
	}

	@Override
	public Reclamation retrieveReclamation(Long id) {
		return this.Reclamationrepo.findById(id).orElse(null);
	}
}
