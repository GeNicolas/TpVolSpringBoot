package com.TpVolSpringBoot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TpVolSpringBoot.demo.entity.CompagnieAerienneKey;
import com.TpVolSpringBoot.demo.entity.CompagnieAerienneVol;

public interface CompagnieAerienneVolRepository extends JpaRepository<CompagnieAerienneVol,CompagnieAerienneKey>{

}
