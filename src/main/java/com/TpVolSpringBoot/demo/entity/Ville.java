package com.TpVolSpringBoot.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity 
@Table(name="ville") 
@SequenceGenerator(name="seqVille", sequenceName="seq_ville", allocationSize=10, initialValue=10) 

public class Ville {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqVille")
	private Long id;
	
	@Column(name="nom")
	private String nom;
	
	@ManyToMany
	@JoinTable(
			name="aeroport_villes",
			joinColumns=@JoinColumn(name="villes", referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="aeroports", referencedColumnName="id")
			)
	private List<Aeroport> aeroports;
	
	// *** Constructeur ***
	public Ville() {
		super();
	}

	public Ville(String nom) {
		super();
		this.nom = nom;
	}

	public Ville(String nom, List<Aeroport> aeroport) {
		super();
		this.nom = nom;
		this.aeroports = aeroport;
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

	public List<Aeroport> getAeroport() {
		return aeroports;
	}
	

	public void setAeroport(List<Aeroport> aeroport) {
		this.aeroports = aeroport;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ville other = (Ville) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
