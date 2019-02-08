package com.TpVolSpringBoot.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.TpVolSpringBoot.demo.entity.Passager;

public interface PassagerRepository extends JpaRepository<Passager,Long>{
	
	@Query("select p from Passager p left join fetch p.reservations where p.id=:numero")
	Optional<Passager> findByIdWithReservation(@Param("numero") Long key);

}
