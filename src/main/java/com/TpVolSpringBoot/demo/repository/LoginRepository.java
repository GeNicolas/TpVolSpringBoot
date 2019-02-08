package com.TpVolSpringBoot.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.TpVolSpringBoot.demo.entity.Login;

public interface LoginRepository extends JpaRepository<Login,Long>{
	
	@Query("select l from Login l join fetch l.roles where l.login=?1")
	Optional<Login> findByLoginWithRoles(String login);
	

}
