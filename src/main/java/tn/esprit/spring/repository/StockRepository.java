package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Stock;

public interface StockRepository extends CrudRepository<Stock, Long>{
	@Query("SELECT s FROM Stock s WHERE s.qteMin >= s.qte")
	List<Stock> retrieveStock();
	List<Stock> findAll();
}
