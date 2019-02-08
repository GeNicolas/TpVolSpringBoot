package com.TpVolSpringBoot.demo.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
	@Column(name = "adresse", length = 100)
private String adresse;
	@Column(name = "code_postal", length = 5)
private String codePostal;
	@Column(name = "ville", length = 150)
private String ville;
	@Column(name = "rue", length = 50)
private String pays;

public Adresse () {
	
}

public Adresse(String adresse, String codePostal, String ville, String pays) {
	super();
	this.adresse = adresse;
	this.codePostal = codePostal;
	this.ville = ville;
	this.pays = pays;
}

public String getAdresse() {
	return adresse;
}

public void setAdresse(String adresse) {
	this.adresse = adresse;
}

public String getCodePostal() {
	return codePostal;
}

public void setCodePostal(String codePostal) {
	this.codePostal = codePostal;
}

public String getVille() {
	return ville;
}

public void setVille(String ville) {
	this.ville = ville;
}

public String getPays() {
	return pays;
}

public void setPays(String pays) {
	this.pays = pays;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
	result = prime * result + ((codePostal == null) ? 0 : codePostal.hashCode());
	result = prime * result + ((pays == null) ? 0 : pays.hashCode());
	result = prime * result + ((ville == null) ? 0 : ville.hashCode());
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
	Adresse other = (Adresse) obj;
	if (adresse == null) {
		if (other.adresse != null)
			return false;
	} else if (!adresse.equals(other.adresse))
		return false;
	if (codePostal == null) {
		if (other.codePostal != null)
			return false;
	} else if (!codePostal.equals(other.codePostal))
		return false;
	if (pays == null) {
		if (other.pays != null)
			return false;
	} else if (!pays.equals(other.pays))
		return false;
	if (ville == null) {
		if (other.ville != null)
			return false;
	} else if (!ville.equals(other.ville))
		return false;
	return true;
}



}
