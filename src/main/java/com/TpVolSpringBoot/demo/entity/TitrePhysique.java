package com.TpVolSpringBoot.demo.entity;

public enum TitrePhysique {
	
		M("monsieur"),MME("madame"),MLLE ("mademoiselle");

		private String texte;

		private TitrePhysique(String texte) {
			this.texte = texte;
		}

		public String getTexte() {
			return texte;
		}

		public void setTexte(String texte) {
			this.texte = texte;
		}
		
		
}
