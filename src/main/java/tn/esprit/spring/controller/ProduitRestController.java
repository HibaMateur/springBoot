package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Produit;

import tn.esprit.spring.service.ProduitServiceImpl;

@RestController
@RequestMapping("/produits")

public class ProduitRestController {
@Autowired
	
	ProduitServiceImpl produitService;
	

	@GetMapping("/retrieve-all-produits")
	
	public List<Produit> getAllProduits() {
		List<Produit> produits  = produitService.retrieveAllProduits();
		return produits;
	}
	
	@GetMapping("/retrieve-produit/{produit-id}")

		public Produit retrieveProduit(@PathVariable("produit-id") Long produitId) {
		return produitService.retrieveProduit(produitId);
	}
	
	@PostMapping("/add-produit/{idRayon}/{idStock}")

	public Produit addProduit(@RequestBody Produit p,@PathVariable Long idRayon,@PathVariable Long idStock)
	{
		Produit produit = produitService.addProduit(p,idRayon,idStock);
		return produit;
	}
	
	@PutMapping("/modify-produit")

	public Produit modifyProduit(@RequestBody Produit produit) {
	return produitService.updateProduit(produit);
	}
	
	@DeleteMapping("/remove-produit/{produit-id}")

	public void removeProduit(@PathVariable("produit-id") Long produitId) {
		produitService.deleteProduit(produitId);
	}
}
