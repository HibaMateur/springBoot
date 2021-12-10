package tn.esprit.spring.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table( name = "Facture")
public class Facture implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idFacture")
	private Long idFacture; 
	
	@Column(name="montantRemise")
	private Float montantRemise;
	
	@Column(name="montantFacture")
	private Float montantFacture;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dateFacture")
	private Date dateFacture;
	

	@Column(name="active")
	private Boolean active;

	@ManyToOne
	Client client;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<DetailFacture> DetailFactures ;

	


}
