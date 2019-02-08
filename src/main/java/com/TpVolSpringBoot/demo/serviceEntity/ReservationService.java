package com.TpVolSpringBoot.demo.serviceEntity;

import org.springframework.beans.factory.annotation.Autowired;

import com.TpVolSpringBoot.demo.repository.ReservationRepository;

public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;

}
