package com.TpVolSpringBoot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TpVolSpringBoot.demo.entity.Login;

public interface LoginRepository extends JpaRepository<Login,Long>{
	

}
