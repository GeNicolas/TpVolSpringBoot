package com.TpVolSpringBoot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TpVolSpringBoot.demo.entity.Escale;
import com.TpVolSpringBoot.demo.entity.EscaleKey;

public interface EscaleRepository extends JpaRepository<Escale,EscaleKey>{

}
