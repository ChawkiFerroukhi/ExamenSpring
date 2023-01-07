package com.example.revision.serviceInterface;

import java.util.List;

import com.example.revision.entities.Salle;

public interface ISalleService {

	public void addSalle (Salle salle) ;
	public void assignSalleToComplexe(Long idSalle, Long idComplexe) ;
	public List<Salle> getListSalleByNomComplexe(String nomComplexe);

}
