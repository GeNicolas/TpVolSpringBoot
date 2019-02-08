package com.TpVolSpringBoot.demo.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;


@Entity 
@Table(name="compagnie") 
@SequenceGenerator(name="seqCompagnie", sequenceName="seq_compagnie", allocationSize=1, initialValue=100) 

public class CompagnieAerienne {

	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqCompagnie")
	private Long id;
	
	@Column(name="nom")
	private String nom;
	
	@OneToMany(mappedBy="key.compagnieAerienne")
	private Set<CompagnieAerienneVol> cav;
	
	@Version
	private int version;
	
	// *** Constructeurs ***

	public CompagnieAerienne(String nom) {
		super();
		this.nom = nom;
	}

	public CompagnieAerienne() {
		super();
	}

	// *** Methodes ***
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<CompagnieAerienneVol> getCav() {
		return cav;
	}

	public void setCav(Set<CompagnieAerienneVol> cav) {
		this.cav = cav;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	
	
	

}
