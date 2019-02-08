package com.TpVolSpringBoot.demo.entity;

import java.util.Set;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="aeroport")
@SequenceGenerator(name="seqAeroport",sequenceName="seq_aeroport", allocationSize=1, initialValue=10) 

@NamedQueries({
	@NamedQuery(name = "Aeroport.findAllWithVol", query = "select distinct a from Aeroport a left join fetch a.vol_arrivee"),
	@NamedQuery(name = "Aeroport.findAllWithVille", query = "select distinct a from Aeroport a left join fetch a.villes") })


public class Aeroport {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqAeroport")
	private Long id;

	@Column(name="nom")
	private String nom;
	
	@OneToMany (mappedBy="aeroportArrivee")
	private Set<Vol> vol_arrivee;
	
	@OneToMany (mappedBy="aeroportDepart")
	private Set<Vol> vol_depart;
	
	@ManyToMany(mappedBy ="aeroports")
	private Set<Ville> villes;
	
	@OneToMany(mappedBy="key.aeroport")
	private Set<Escale> escale;
	
	
	
	
	// *** Constructeur ***
	
	public Aeroport() {
		super();
	}

	public Aeroport(String nom, Set<Ville> ville, Set<Escale> escale) {
		super();
		this.nom = nom;
		this.villes = ville;
		this.escale = escale;
	}
	
	public Aeroport(String nom, Set<Vol> vol_arrivee, Set<Vol> vol_depart, Set<Ville> villes, Set<Escale> escale) {
		super();
		this.nom = nom;
		this.vol_arrivee = vol_arrivee;
		this.vol_depart = vol_depart;
		this.villes = villes;
		this.escale = escale;
	}

	// *** Methodes ***

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<Ville> getVille() {
		return villes;
	}

	public void setVille(Set<Ville> ville) {
		this.villes = ville;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}




	public Set<Vol> getVol_arrivee() {
		return vol_arrivee;
	}

	public void setVol_arrivee(Set<Vol> vol_arrivee) {
		this.vol_arrivee = vol_arrivee;
	}

	public Set<Vol> getVol_depart() {
		return vol_depart;
	}

	public void setVol_depart(Set<Vol> vol_depart) {
		this.vol_depart = vol_depart;
	}

	public Set<Ville> getVilles() {
		return villes;
	}

	public void setVilles(Set<Ville> villes) {
		this.villes = villes;
	}

	public Set<Escale> getEscale() {
		return escale;
	}

	public void setEscale(Set<Escale> escale) {
		this.escale = escale;
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
		Aeroport other = (Aeroport) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
