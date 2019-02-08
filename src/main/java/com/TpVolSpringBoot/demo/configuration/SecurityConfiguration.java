package com.TpVolSpringBoot.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.TpVolSpringBoot.demo.serviceConfiguration.CustomClientDetailsService;



@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Gestion des pages authorisés
		http.csrf().disable();
			//pas d'authorisation pour la page d'accueil
		http.authorizeRequests().antMatchers("/index").permitAll();
		http.authorizeRequests().antMatchers("/indexTest").permitAll();//Tester que la securite fctionne
			//securiser les eventuels web services
		http.authorizeRequests().antMatchers("/rest/**").authenticated().and().httpBasic();
		http.authorizeRequests().antMatchers("/api/**").permitAll();
		//Gestion des pages accessibles sous login
		http.authorizeRequests().antMatchers("/index/**").authenticated().and().formLogin().loginPage("/login")
			//mise en forme de notre propre formulaire d'authentification -> page "login"
		.loginPage("/login").failureUrl("/login?error=true").permitAll()
		//logout(): gestion de la deconnection
		.and().logout().logoutSuccessUrl("/index");
		http.authorizeRequests().antMatchers("/include/**").authenticated().and().formLogin().loginPage("/login")
		.loginPage("/login").failureUrl("/login?error=true").permitAll()
		.and().logout().logoutSuccessUrl("/index");
	}
	
	@Autowired
	private CustomClientDetailsService clientDetailsService;
	
	@Override
		//Necessite un CustomUserDetailsService
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(clientDetailsService).passwordEncoder(getPasswordEncoder());
	}
	
	@Bean (name="passwordEncoder")
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
