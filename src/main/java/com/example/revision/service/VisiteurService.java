package com.example.revision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.revision.entities.Salle;
import com.example.revision.entities.Visiteur;
import com.example.revision.repositories.SalleRepository;
import com.example.revision.repositories.VisiteurRepository;
import com.example.revision.serviceInterface.IVisiteurService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class VisiteurService implements IVisiteurService {

    @Autowired
    private VisiteurRepository visiteurRepository;

    @Autowired
    private SalleRepository salleRepository;

    @Override
    public void addVisiteur(Visiteur visiteur) {
        visiteurRepository.save(visiteur);
    }

    @Override
    public void assignVisiteurToSalle(Long visiteurId, Long salleId) {
        Visiteur visiteur = visiteurRepository.findById(visiteurId).orElse(null);
        Salle salle = salleRepository.findById(salleId).orElse(null);

        salle.getVisiteurs().add(visiteur);

    }

    @Override
    public List<Visiteur> getAllVisiteur() {
        return visiteurRepository.findAll();
    }

    @Scheduled(cron = "*/10 * * * * *")
	@Override
	public String retrieveVisiteurs() {
		List<Visiteur> visiteurs = visiteurRepository.retrieveVisiteurs();
		String msg ="";
		for (Visiteur visiteur : visiteurs) {
			msg = msg +visiteur.toString();
		}
		log.info(msg);
		return msg;
	}



    
}
