package com.relacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relacionamento.entities.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{

}
