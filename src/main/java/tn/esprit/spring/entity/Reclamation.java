package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Reclamation implements Serializable  {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	//primary generate auto value
	@Column(name="idReclamation")
	private Long idReclamation; 
	@Temporal(TemporalType.DATE)
	@Column(name="dateReclamation")
	private Date dateReclamation;
	@ManyToOne
	private Client clientReclamation; 
	@Column(name="adresse")
	private String adresse;
	@Column(name="description")
	private String description;
	

}
