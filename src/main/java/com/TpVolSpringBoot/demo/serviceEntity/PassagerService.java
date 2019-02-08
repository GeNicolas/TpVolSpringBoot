package com.TpVolSpringBoot.demo.serviceEntity;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.TpVolSpringBoot.demo.entity.Passager;
import com.TpVolSpringBoot.demo.entity.Reservation;
import com.TpVolSpringBoot.demo.repository.PassagerRepository;
import com.TpVolSpringBoot.demo.repository.ReservationRepository;

public class PassagerService {

	@Autowired
	private PassagerRepository passagerRepository;
	
	@Autowired
	private ReservationRepository reservationRepo;
	
	public void deletePassagerWithReservation(Long key) {
		Optional<Passager> opt = passagerRepository.findByIdWithReservation(key);
		
		Passager passager = null;
		
		if (opt.isPresent()) {
			passager = opt.get();
			for (Reservation r : passager.getReservations()) {
				r.setPassager(null);
				reservationRepo.save(r);
			}
			passagerRepository.delete(passager);
		}
	}

}
