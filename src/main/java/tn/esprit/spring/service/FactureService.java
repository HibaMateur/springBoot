package tn.esprit.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.Stock;


@Service
public interface FactureService 
{
	List<Facture> retrieveAllFactures();

	void cancelFacture(Long id);
	Facture addFacture(Facture f);

	Facture updateFacture(Facture f);

	void deleteFacture(Long id);
	Facture retrieveFacture(Long id);	

}
