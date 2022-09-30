package com.entra21_Spring.entra21_Spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entra21_Spring.entra21_Spring.model.Fabricante;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Long>{

	@Query(value = "select f from Fabricante f where f.origem = ?1")
	List<Fabricante> findByOrigem(String origem);
	
	@Query(value = "select f from Fabricante f where upper (trim(f.nome)) like %?1%")
	List<Fabricante> findByNomeLike(String nome);
}
