package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.DetailProduit;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.ProduitRepository;


@Service
public class ProduitServiceImpl implements ProduitService {

	@Autowired
	ProduitRepository Produitrepo;

	@Autowired
	StockService stockService;
	
	
	@Autowired
	RayonService rayonService;
	
	@Autowired
	DetailProduitService detailProduitService;

	@Override
	public List<Produit> retrieveAllProduits() {
        return (List<Produit>) this.Produitrepo.findAll();
	}

	@Override
	public Produit addProduit(Produit p, Long idRayon, Long idStock) {
		p.setRayonproduit(rayonService.retrieveRayon(idRayon));
		p.setStockproduit(stockService.retrieveStock(idStock));
		//DetailProduit d=detailProduitService.addDetailProduit(p.getDetailproduit());
		//p.setDetailproduit(d);
		return Produitrepo.save(p);
	}

	@Override
	public void deleteProduit(Long id) {
		Produitrepo.deleteById(id);
		
	}

	@Override
	public Produit updateProduit(Produit c) {
		Produit Produit = Produitrepo.findById(c.getIdProduit()).orElse(null);
		if(Produit != null)
			Produitrepo.save(c);
        return c;
	}

	@Override
	public Produit retrieveProduit(Long id) {
		return this.Produitrepo.findById(id).orElse(null);
	}

}
