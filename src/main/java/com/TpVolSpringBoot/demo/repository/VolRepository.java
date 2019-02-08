package com.TpVolSpringBoot.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.TpVolSpringBoot.demo.entity.Aeroport;
import com.TpVolSpringBoot.demo.entity.CompagnieAerienne;
import com.TpVolSpringBoot.demo.entity.Reservation;
import com.TpVolSpringBoot.demo.entity.Vol;

public interface VolRepository extends JpaRepository<Vol,Long> {
	Optional<Vol> findByIdWithReservation(@Param("id") Long id); //Requete nomm�e
	Optional<Vol> findByIdWithAeroportDepart(@Param("id") Long id); //Requete nomm�e
	Optional<Vol> findByIdWithAeroportArrivee(@Param("id") Long id); //Requete nomm�e
	Optional<Vol> findByIdWithCompagnie(@Param("id") Long id); //Requete nomm�e
	Optional<Vol> findAllWithCompagnie(CompagnieAerienne compagnieAerienne); //Requete nomm�e
	Optional<Vol> findAllWithAeroportDepart(Aeroport aeroportDepart); //Requete nomm�e
	Optional<Vol> findAllWithAeroportArrivee(Aeroport aeroportArrive); //Requete nomm�e
	Optional<Vol> findAllWithReservation(Reservation reservation); //Requete nomm�e
	//void deleteEscale(Vol vol); // suppr Vol entraine suppr des escales --> cf VolService
	
	@Query("select distinct v from Vol v where v.aeroportArrivee=:aeroportArrivee AND v.aeroportDepart=:aeroportDepart")
	Optional<List<Vol>> findWithAeroportArriveeDepart(@Param("aeroportArrivee") Aeroport aeroportArrivee,@Param("aeroportDepart") Aeroport aeroportDepart);
	
	
	

}
