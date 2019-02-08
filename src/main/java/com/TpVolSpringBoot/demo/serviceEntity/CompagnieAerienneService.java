package com.TpVolSpringBoot.demo.serviceEntity;

import org.springframework.beans.factory.annotation.Autowired;

import com.TpVolSpringBoot.demo.repository.CompagnieAerienneRepository;

public class CompagnieAerienneService {

	@Autowired
	private CompagnieAerienneRepository compagnieAerienneRepository;
}
