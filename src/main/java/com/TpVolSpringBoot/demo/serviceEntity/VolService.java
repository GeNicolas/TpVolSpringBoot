package com.TpVolSpringBoot.demo.serviceEntity;

import org.springframework.beans.factory.annotation.Autowired;

import com.TpVolSpringBoot.demo.entity.Escale;
import com.TpVolSpringBoot.demo.entity.Vol;
import com.TpVolSpringBoot.demo.repository.EscaleRepository;
import com.TpVolSpringBoot.demo.repository.VolRepository;

public class VolService {

	@Autowired
	private VolRepository volRepository;
	
	@Autowired
	private EscaleRepository escaleRepository;
	
	public void deleteEscale(Vol vol) {
	
		for (Escale e: vol.getEscale()) {
			e.setKey(null);
			e.setHeureDepart(null);
			e.setHeureArrivee(null);
			escaleRepository.delete(e);
		}
	 volRepository.delete(vol);	
	}

}
