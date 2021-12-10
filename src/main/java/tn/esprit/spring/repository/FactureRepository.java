package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.Stock;

@Repository

public interface FactureRepository extends CrudRepository<Facture, Long>{
	
	@Query("SELECT sum(f.montantFacture) FROM Facture f where idFacture<>null")
	List<Facture> retrieveFacture();
}
