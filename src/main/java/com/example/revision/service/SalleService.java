package com.example.revision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.revision.entities.Complexe;
import com.example.revision.entities.Salle;
import com.example.revision.repositories.ComplexeRepository;
import com.example.revision.repositories.SalleRepository;
import com.example.revision.serviceInterface.ISalleService;

@Service
public class SalleService implements ISalleService {

    @Autowired
    private SalleRepository salleRepository;

    @Autowired
    private ComplexeRepository complexeRepository;

    @Override
    public void addSalle(Salle salle) {
        salleRepository.save(salle);
    }

    @Override
    public void assignSalleToComplexe(Long idSalle, Long idComplexe) {
        Salle salle = salleRepository.findById(idSalle).orElse(null);
        Complexe complexe = complexeRepository.findById(idComplexe).orElse(null);
        if (salle != null && complexe != null) {
            salle.setComplexe(complexe);
            salleRepository.save(salle);
        }
    }

    @Override
    public List<Salle> getListSalleByNomComplexe(String nomComplexe) {
        return salleRepository.getListSalleByNomComplexe(nomComplexe);
    }

    
}
