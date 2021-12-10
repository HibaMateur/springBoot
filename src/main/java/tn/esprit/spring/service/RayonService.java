package tn.esprit.spring.service;

import tn.esprit.spring.entity.Rayon;


public interface RayonService {



	Rayon addRayon(Rayon r);

	

	Rayon retrieveRayon(Long id);
}
