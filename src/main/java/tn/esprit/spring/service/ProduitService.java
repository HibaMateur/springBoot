package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Produit;

public interface ProduitService {
	List<Produit> retrieveAllProduits();

	Produit addProduit(Produit p, Long idRayon, Long idStock);
	void deleteProduit(Long id);

	Produit updateProduit(Produit p);
	Produit retrieveProduit(Long id);

}
