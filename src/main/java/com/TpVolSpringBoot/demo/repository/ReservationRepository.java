package com.TpVolSpringBoot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TpVolSpringBoot.demo.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Integer>{

}
