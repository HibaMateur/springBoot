package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import lombok.Getter;

import lombok.Setter;



@Entity
@Getter
@Setter


@Table( name = "DetailProduit")
public class DetailProduit implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idDetailProduit")
	private Long idDetailProduit; 
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	@Temporal(TemporalType.DATE)
    private Date dateDerniereModification;
	@Enumerated(EnumType.STRING)
	private  CategorieProduit categorieProduit;
	
	
	
	
	@OneToOne(mappedBy="Detailproduit")
	private Produit Detailproduitt; 
	
	
	
	
}
