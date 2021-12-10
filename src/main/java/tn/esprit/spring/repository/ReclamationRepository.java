package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.entity.Stock;

public interface ReclamationRepository extends CrudRepository<Reclamation, Long> {

}
