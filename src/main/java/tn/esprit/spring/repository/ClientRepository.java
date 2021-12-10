package tn.esprit.spring.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Client;




@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
	@Query("SELECT c FROM Client c WHERE c.dateNaissance BETWEEN ':d1' AND ':d2' ")
	public List<Client> retrieveClientsByDate(
	@Param("d1") Date d1,	@Param("d1") Date d2);
	
	
	@Query(value = "SELECT c FROM Client c WHERE c.dateNaissance BETWEEN ':d1' AND ':d2'",
			nativeQuery = true)
			public List<Client> retrieveClientsByDate_SQL(
			@Param("d1") Date d1,	@Param("d1") Date d2);
}
