package com.relacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relacionamento.entities.Pedido;

public interface pedidoRepository extends JpaRepository<Pedido, Long>{

}
