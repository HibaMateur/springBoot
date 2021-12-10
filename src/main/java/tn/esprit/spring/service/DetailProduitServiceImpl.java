package tn.esprit.spring.service;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.DetailProduit;
import tn.esprit.spring.repository.DetailProduitRepository;

@Service
public class DetailProduitServiceImpl  implements DetailProduitService{

	DetailProduitRepository detailProduitRepository;
	@Override
	public DetailProduit addDetailProduit(DetailProduit d) {
	
		return detailProduitRepository.save(d);
	}

}
