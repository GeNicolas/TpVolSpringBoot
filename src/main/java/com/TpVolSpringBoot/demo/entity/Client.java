package com.TpVolSpringBoot.demo.entity;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="Client")
@SequenceGenerator(name="seqClient", sequenceName="seq_client", allocationSize=1, initialValue=100)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",length=5)

public abstract class Client {
		@Id
		@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seqClient")
		@Column(name="client_number")
		 private Long id;
		@Column(name="client_surname", nullable = false)
		 private String nom;
		@Column(name="client_numerotel")
		 private Integer numerotel;
		@Column(name="client_fax", nullable = false)
		 private Integer numerofax;
		@Column(name="client_email", nullable = false)
		 private String email;
		@Embedded	 
		@AttributeOverrides({ @AttributeOverride(name = "adresse", column = @Column(name = "adress")),
			@AttributeOverride(name = "pays", column = @Column(name = "country", length = 150)),
			@AttributeOverride(name = "codePostal", column = @Column(name = "zip_code", length = 5)),
			@AttributeOverride(name = "ville", column = @Column(name = "city", length = 150)) })
		private Adresse adresse;
		@OneToMany(mappedBy="client")
		private Set <Reservation> reservation;
		
		
		@OneToOne
		@JoinColumn(name="login")
		private Login login;
		@Version
		private int version;
		
		public Client() {
			super();
		}


		public Client( String nom, Integer numerotel, Integer numerofax, String email) {
			super();
			this.nom = nom;
			this.numerotel = numerotel;
			this.numerofax = numerofax;
			this.email = email;
		}



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


		public Integer getNumerotel() {
			return numerotel;
		}


		public void setNumerotel(Integer numerotel) {
			this.numerotel = numerotel;
		}


		public Integer getNumerofax() {
			return numerofax;
		}


		public void setNumerofax(Integer numerofax) {
			this.numerofax = numerofax;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public Adresse getAdresse() {
			return adresse;
		}


		public void setAdresse(Adresse adresse) {
			this.adresse = adresse;
		}


		public Set<Reservation> getReservation() {
			return reservation;
		}


		public void setReservation(Set<Reservation> reservation) {
			this.reservation = reservation;
		}


		public Login getLogin() {
			return login;
		}


		public void setLogin(Login login) {
			this.login = login;
		}


		public int getVersion() {
			return version;
		}


		public void setVersion(int version) {
			this.version = version;
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
			Client other = (Client) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
		 
		 
		 
		 
		 
}
