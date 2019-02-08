package com.TpVolSpringBoot.demo.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;



@Entity 
@Table(name="vol") 
@SequenceGenerator(name="seqVol", sequenceName="seq_vol", allocationSize=1, initialValue=1000) 

@NamedQueries({
	@NamedQuery(name = "Vol.findByIdWithReservation", query = "select distinct v from Vol v left join fetch v.reservation where v.id =:id"),
	@NamedQuery(name = "Vol.findByIdWithAeroportDepart", query = "select distinct v from Vol v left join fetch v.aeroportDepart where v.id =:id"),
	@NamedQuery(name = "Vol.findByIdWithAeroportArrivee", query = "select distinct v from Vol v left join fetch v.aeroportArrivee where v.id= :id"),
	@NamedQuery(name = "Vol.findByIdWithCompagnie", query = "select distinct v from Vol v left join fetch v.compagnieAerienne where v.id =:id"),
	@NamedQuery (name = "Vol.findAllWithCompagnie", query = "select distinct v from Vol v left join fetch v.compagnieAerienne"),
	@NamedQuery (name = "Vol.findAllWithAeroportDepart", query = "select distinct v from Vol v left join fetch v.aeroportDepart"),
	@NamedQuery (name = "Vol.findAllWithAeroportArrivee", query = "select distinct v from Vol v left join fetch v.aeroportArrivee"),
	@NamedQuery (name = "Vol.findAllWithReservation", query = "select distinct v from Vol v left join fetch v.reservation")})

public class Vol {

	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqVol")
	private Long id;
	
	//@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="date_depart")
	private Date dateDepart;
	
	//@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="date_arrive")
	private Date dateArrivee;
	
	@Temporal(TemporalType.TIME)
	@Column(name="heure_depart")
	private Date heureDepart;
	
	@Temporal(TemporalType.TIME)
	@Column(name="heure_arrive")
	private Date heureArrivee;
	
	@OneToMany(mappedBy="vol")
	private Set<Reservation> reservation;
	
	@ManyToOne
	@JoinColumn(name="aeroport_arrive_id")
	private Aeroport aeroportArrivee;
	
	@ManyToOne
	@JoinColumn(name="aeroport_depart_id")
	private Aeroport aeroportDepart;
	
	@OneToMany(mappedBy="key.vol")
	private Set<CompagnieAerienneVol> compagnieAerienne;
	
	@OneToMany(mappedBy="key.vol")
	private Set<Escale> escale;
	
	@Version
	private int version;

	
	
	// *** Constructeurs ***
	
	public Vol() {
		super();
	}
	
	public Vol(Date dateDepart, Date dateArrivee, Date heureDepart, Date heureArrivee) {
		super();
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
	}

	public Vol(Date dateDepart, Date dateArrivee, Date heureDepart, Date heureArrivee, Set<Reservation> reservation,
			Aeroport aeroport_arrive, Aeroport aeroport_depart) {
		super();
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
		this.reservation = reservation;
		this.aeroportArrivee = aeroport_arrive;
		this.aeroportDepart = aeroport_depart;
	}

	
	// *** Methodes ***
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Date getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public Date getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(Date heureDepart) {
		this.heureDepart = heureDepart;
	}

	public Date getHeureArrivee() {
		return heureArrivee;
	}

	public void setHeureArrivee(Date heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

	public Set<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation( Set<Reservation> reservation) {
		this.reservation = reservation;
	}

	

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	
	public Aeroport getAeroportArrivee() {
		return aeroportArrivee;
	}

	public void setAeroportArrivee(Aeroport aeroportArrivee) {
		this.aeroportArrivee = aeroportArrivee;
	}

	public Aeroport getAeroportDepart() {
		return aeroportDepart;
	}

	public void setAeroportDepart(Aeroport aeroportDepart) {
		this.aeroportDepart = aeroportDepart;
	}

	public Set<CompagnieAerienneVol> getCompagnieAerienne() {
		return compagnieAerienne;
	}

	public void setCompagnieAerienne(Set<CompagnieAerienneVol> compagnieAerienne) {
		this.compagnieAerienne = compagnieAerienne;
	}

	public Set<Escale> getEscale() {
		return escale;
	}

	public void setEscale(Set<Escale> escale) {
		this.escale = escale;
	}

	

}
