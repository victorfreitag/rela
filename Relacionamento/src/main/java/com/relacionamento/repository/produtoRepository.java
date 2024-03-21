package com.relacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relacionamento.entities.Produto;

public interface produtoRepository extends JpaRepository<Produto, Long>{

}
