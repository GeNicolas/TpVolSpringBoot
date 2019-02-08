package com.TpVolSpringBoot.demo.serviceConfiguration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import com.TpVolSpringBoot.demo.entity.Login;
import com.TpVolSpringBoot.demo.entityConfiguration.LoginRole;

public class CustomClientDetails implements UserDetails {
	
	private Login log;

	public CustomClientDetails(Login log) {
		super();
		this.log = log;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<String> roles = new ArrayList<>();
		for (LoginRole role : log.getRoles()) {
			roles.add(role.getRole().toString());
		}	
		return AuthorityUtils.commaSeparatedStringToAuthorityList(StringUtils.collectionToCommaDelimitedString(roles));
	}
	

	@Override
	public String getPassword() {
		return log.getMotDePasse();
	}

	@Override
	public String getUsername() {
		return log.getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return log.getEnable();
	}

}
