package tn.esprit.spring.entity;
import java.io.Serializable;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;

import lombok.Setter;


@Entity
@Getter
@Setter

@Table( name = "Produit")
public class Produit implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idproduit")
	private Long idProduit;
	private String code;
	private String libelle;
	private float prixUnitaire;
	@ManyToOne
	private Stock stockproduit; 
	
	@ManyToOne
	private Rayon rayonproduit; 
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Totheparentdetailfacture")
	private Set<DetailFacture> detailFacture;
	@OneToOne
	private DetailProduit Detailproduit;
	

	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL) 
	private Set<Fournisseur> fournisseurproduit;

	
	

}