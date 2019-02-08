package com.TpVolSpringBoot.demo.serviceConfiguration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.TpVolSpringBoot.demo.entity.Login;
import com.TpVolSpringBoot.demo.repository.LoginRepository;

@Service
class ConsoleApplication implements CommandLineRunner{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private LoginRepository loginRepository;

	@Override
	public void run(String... args) throws Exception {
		List<Login> logins = loginRepository.findAll();
		for (Login l : logins) {
			l.setMotDePasse(passwordEncoder.encode(l.getLogin()));
			loginRepository.save(l);
		}
		
	}
	

}
