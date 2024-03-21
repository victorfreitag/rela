package com.relacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relacionamento.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
