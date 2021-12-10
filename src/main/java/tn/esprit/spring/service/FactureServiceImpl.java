package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.FactureRepository;

public class FactureServiceImpl implements FactureService{
	
	@Autowired
	FactureRepository Facturerepo;

	
	@Override
	public Facture addFacture(Facture f) {
        return this.Facturerepo.save(f);
	}
	@Override
	public void deleteFacture(Long id) {
		Facturerepo.deleteById(id);
		
	}
	@Override
	public List<Facture> retrieveAllFactures() {
        return (List<Facture>) this.Facturerepo.findAll();
	}
	@Override
	public Facture updateFacture(Facture c) {
		Facture facture = Facturerepo.findById(c.getIdFacture()).orElse(null);
		if(facture != null)
			Facturerepo.save(c);
        return c;
	}
	@Override
	public void cancelFacture(Long id) {
		Facture Facture = Facturerepo.findById(id).orElse(null);
		Facture.setActive(false);
	}

	@Override
	public Facture retrieveFacture(Long id) {
		return this.Facturerepo.findById(id).orElse(null);
	}
	@Scheduled(cron = "0 0 0 1 * *" )
	public void calculFacture() {
		List<Facture> factureList;
		factureList = (List<Facture>) Facturerepo.retrieveFacture();
		for (Facture facture : factureList) {
			System.out.println(facture.getMontantFacture());
		}
		}
	}


