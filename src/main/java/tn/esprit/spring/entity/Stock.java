package tn.esprit.spring.entity;

import java.io.Serializable;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
@Table( name = "Stock")

public class Stock implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idStock")
	private Long idStock; 

	@Column(name="qte")
	private Integer qte;

	@Column(name="qteMin")
	private Integer qteMin;
	
	@Column(name="LibelleStock")
	private String LibelleStock;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Produit> Produit;


}
