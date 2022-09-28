package com.entra21_Spring.entra21_Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entra21_Spring.entra21_Spring.model.Fabricante;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Long>{

}
