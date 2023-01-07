package com.example.revision.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.revision.entities.Complexe;

@Repository
public interface ComplexeRepository extends JpaRepository<Complexe, Long> {

}
