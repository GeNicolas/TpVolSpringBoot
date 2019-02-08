package com.TpVolSpringBoot.demo.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Version;
@Entity
@DiscriminatorValue(value="CM")
public class ClientMoral extends Client{
	@Embedded
	@Column(name="title")
	private TitreMoral titre;
	@Column(name="siret")
	private String siret;
	@Version
	private int version;
	
	public ClientMoral () {
		super();
		
	}
	public ClientMoral( String nom, Integer numerotel, Integer numerofax, String email, TitreMoral titre, String siret) {
		super( nom, numerotel, numerofax, email);
		// TODO Auto-generated constructor stub
	}
	
	

	public TitreMoral getTitre() {
		return titre;
	}

	public void setTitre(TitreMoral titre) {
		this.titre = titre;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}

}
