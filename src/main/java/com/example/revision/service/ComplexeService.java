package com.example.revision.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.revision.entities.Complexe;
import com.example.revision.repositories.ComplexeRepository;
import com.example.revision.serviceInterface.IComplexeService;

@Service
public class ComplexeService implements IComplexeService {

    @Autowired
    private ComplexeRepository complexeRepository;

    @Override
    public void addComplexe(Complexe complexe) {
        complexeRepository.save(complexe);
    }
    
}
