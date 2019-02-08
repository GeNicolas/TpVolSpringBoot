package com.TpVolSpringBoot.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.TpVolSpringBoot.demo.entityConfiguration.LoginRole;

@Entity
@Table(name = "Login")
@SequenceGenerator(name ="seqLogin", sequenceName="seq_login", allocationSize=1, initialValue=1)
public class Login {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqLogin")
	private Long id;
	@Column(name="login")
	private String login;
	@Column(name="password")
	private String motDePasse;
	@Column(name="admin")
	private Boolean admin;
	@Column(name="enable")
	private Boolean enable;
	@OneToMany(mappedBy = "log")
	private List<LoginRole> roles;
	
	
	public List<LoginRole> getRoles() {
		return roles;
	}


	public void setRole(List<LoginRole> roles) {
		this.roles = roles;
	}


	public Boolean getEnable() {
		return enable;
	}


	public Boolean getAdmin() {
		return admin;
	}


	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}


	public void setEnable(Boolean enable) {
		this.enable = enable;
	}


	@Version
	private int version;
	
	@OneToOne(mappedBy = "login")
	private Client client;
	
	//Constructeurs
	
	
	
	public Login(String login, String motDePasse, boolean admin) {
		super();
		this.login = login;
		this.motDePasse = motDePasse;
		this.admin = admin;
	}

	
	public Login() {
		super();
	}
	
	// M�thodes


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getMotDePasse() {
		return motDePasse;
	}


	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}


	public boolean isAdmin() {
		return admin;
	}


	public void setAdmin(boolean admin) {
		this.admin = admin;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
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
		Login other = (Login) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
