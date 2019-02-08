package com.TpVolSpringBoot.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TpVolSpringBoot.demo.entity.Aeroport;


public interface AeroportRepository  extends JpaRepository<Aeroport, Long>{
	Optional<Aeroport> findByNom(String nom); 
	Optional<Aeroport> findByNomLike(String nom);
	//void deleteAeroportArriveWithVolArrive(Vol volArrive);
	//void deleteAeroportDepartWithVolDepart(Vol volDepart);
}
