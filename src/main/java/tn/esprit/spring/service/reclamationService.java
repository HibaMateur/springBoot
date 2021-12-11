package tn.esprit.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.entity.Stock;

public interface reclamationService {
	List<Reclamation> retrieveAllReclamations();

	Reclamation addReclamation(Reclamation r);

	Reclamation updateReclamation(Reclamation r);

	Reclamation retrieveReclamation(Long id);
	void deleteReclamation(Long id);


}
