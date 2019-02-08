package com.TpVolSpringBoot.demo.serviceEntity;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.TpVolSpringBoot.demo.entity.Client;
import com.TpVolSpringBoot.demo.entity.Login;
import com.TpVolSpringBoot.demo.entity.Reservation;
import com.TpVolSpringBoot.demo.repository.ClientRepository;
import com.TpVolSpringBoot.demo.repository.LoginRepository;
import com.TpVolSpringBoot.demo.repository.ReservationRepository;

public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	public void deleteClientWithReservationAndLogin(Long key) {
		Optional<Client> opt = clientRepository.findByIdWithReservationAndLogin(key);
		Client c = null;
		
		if (opt.isPresent()) {
			c = opt.get();
			for(Reservation r : c.getReservation()) {
				r.setClient(null);
				reservationRepository.save(r);
			}
			Login l = c.getLogin();
			loginRepository.delete(l);
			
		}
	}
	

}
