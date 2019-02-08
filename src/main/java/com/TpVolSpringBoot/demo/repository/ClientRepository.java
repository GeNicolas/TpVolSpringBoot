package com.TpVolSpringBoot.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.TpVolSpringBoot.demo.entity.Client;

public interface ClientRepository extends JpaRepository<Client,Long>{
	
	@Query("select c from Client c left join fetch c.reservation where c.id=:numero")
	Optional<Client> findByIdWithReservation(@Param("numero") Long key);
	
	@Query("select c from Client c left join fetch c.reservation left join fetch c.login where c.id=:numero")
	Optional<Client> findByIdWithReservationAndLogin(@Param("numero") Long key);
}
