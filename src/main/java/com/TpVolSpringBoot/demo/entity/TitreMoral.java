package com.TpVolSpringBoot.demo.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TitreMoral {

	 private String titre_moral;

	 public TitreMoral () {
		 
	 }
	public TitreMoral(String titre_moral) {
		super();
		this.titre_moral = titre_moral;
	}

	public String getTitre_moral() {
		return titre_moral;
	}

	public void setTitre_moral(String titre_moral) {
		this.titre_moral = titre_moral;
	}

	 

}
