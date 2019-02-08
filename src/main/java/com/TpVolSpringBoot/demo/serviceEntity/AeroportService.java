package com.TpVolSpringBoot.demo.serviceEntity;

import org.springframework.beans.factory.annotation.Autowired;

import com.TpVolSpringBoot.demo.entity.Aeroport;
import com.TpVolSpringBoot.demo.entity.Vol;
import com.TpVolSpringBoot.demo.repository.AeroportRepository;
import com.TpVolSpringBoot.demo.repository.VolRepository;

public class AeroportService {
	
	@Autowired
	private AeroportRepository aeroportRepository;
	
	@Autowired
	private VolRepository volRepository;
	
	public void deleteAeroportArriveWithVolArrive(Vol volArrive) {
		Aeroport a = volArrive.getAeroportArrivee();
		volArrive.setAeroportArrivee(null);
		volRepository.save(volArrive);
		aeroportRepository.delete(a);	
	}
	
	public void deleteAeroportDepartWithVolDepart(Vol volDepart) {
		Aeroport a = volDepart.getAeroportDepart();
		volDepart.setAeroportDepart(null);
		volRepository.save(volDepart);
		aeroportRepository.delete(a);	
	}


}
