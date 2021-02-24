package com.compremais.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compremais.farmacia.model.CategoriaModel;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long>{

	public List<CategoriaModel> findAllByNomeCategoriaContainingIgnoreCase(String nome);
}
