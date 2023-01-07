package com.example.revision.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.revision.entities.Salle;

@Repository
public interface SalleRepository extends JpaRepository<Salle, Long> {

    @Query("select s from Salle s where s.complexe.nomComplexe = :nomComplexe")
    public List<Salle> getListSalleByNomComplexe(@Param("nomComplexe") String nomComplexe);

}