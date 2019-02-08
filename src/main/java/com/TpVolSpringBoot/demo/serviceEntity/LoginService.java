package com.TpVolSpringBoot.demo.serviceEntity;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.TpVolSpringBoot.demo.entity.Client;
import com.TpVolSpringBoot.demo.entity.Login;
import com.TpVolSpringBoot.demo.repository.ClientRepository;
import com.TpVolSpringBoot.demo.repository.LoginRepository;

public class LoginService {

	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private ClientRepository clientRepo;
	
	public void deleteLoginWithClient(Long key) {
		Optional<Login> opt = loginRepository.findById(key);
		Login login =null;
		Client c =null;
		if (opt.isPresent()) {
			login= opt.get();
			c =login.getClient();
			c.setLogin(null);
			clientRepo.save(c);
			loginRepository.delete(login);
		}
		
	}

}
