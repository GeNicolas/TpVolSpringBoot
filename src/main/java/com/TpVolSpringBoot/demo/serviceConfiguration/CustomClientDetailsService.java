package com.TpVolSpringBoot.demo.serviceConfiguration;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.TpVolSpringBoot.demo.entity.Login;
import com.TpVolSpringBoot.demo.repository.LoginRepository;

@Service
public class CustomClientDetailsService implements UserDetailsService {

	@Autowired
	private LoginRepository loginRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		
		Optional<Login> opt = loginRepository.findByLoginWithRoles(login);
		if (opt.isPresent()) {
			return new CustomClientDetails(opt.get());
		}
		throw new UsernameNotFoundException("Utilisateur inconnu");
	}




	

	

	

}
