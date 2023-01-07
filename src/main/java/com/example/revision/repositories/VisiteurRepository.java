package com.example.revision.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.revision.entities.Visiteur;

@Repository
public interface VisiteurRepository extends JpaRepository<Visiteur, Long> {

    // retrieve visiteur where age > 18 
    @Query("select v from Visiteur v where (NOW() - v.dateNaissance) < '18'")
    List<Visiteur> retrieveVisiteurs();
        

}