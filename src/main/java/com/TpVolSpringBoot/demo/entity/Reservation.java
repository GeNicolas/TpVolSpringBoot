package com.TpVolSpringBoot.demo.entity;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Reservation")
@SequenceGenerator(name="seqReservation", sequenceName="seq_reservation", allocationSize = 1, initialValue=1)
public class Reservation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqReservation")
	private Long id;
	//@Column(name="date_reservation", nullable=false)
	//@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	@Column(name="numero", nullable=true)
	private Integer numero;
	@Version
	private int version;
	@ManyToOne
	@JoinColumn(name="passager")
	private Passager passager;
	@ManyToOne
	@JoinColumn(name="client")
	private Client client;
	@ManyToOne
	@JoinColumn(name="vol_id")
	private Vol vol;
	
	
	
	// Constructeur
	public Reservation(Date date, Integer numero) {
		super();
		this.date = date;
		this.numero = numero;
	}

	public Reservation() {
		super();
	}
	
	// M�thodes

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}
	
	

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Passager getPassager() {
		return passager;
	}

	public void setPassager(Passager passager) {
		this.passager = passager;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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
		Reservation other = (Reservation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
