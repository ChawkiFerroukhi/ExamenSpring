package com.example.revision.serviceInterface;

import java.util.List;

import com.example.revision.entities.Visiteur;

public interface IVisiteurService {
	public void addVisiteur(Visiteur v);
	public void assignVisiteurToSalle(Long visiteurId, Long salleId);
	List <Visiteur>  getAllVisiteur() ;
	String retrieveVisiteurs();

}
