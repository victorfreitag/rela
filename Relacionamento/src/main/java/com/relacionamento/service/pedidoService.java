package com.relacionamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relacionamento.entities.Pedido;
import com.relacionamento.repository.pedidoRepository;

@Service
public class pedidoService {
	
	private final pedidoRepository pedidoRepository;

	@Autowired
	public pedidoService(pedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}
	public List<Pedido> buscaTodosPedido(){
		return pedidoRepository.findAll();
	}
	public Pedido buscaPedidoId(Long id) {
		Optional <Pedido> pedido = pedidoRepository.findById(id);
		return pedido.orElse(null);
	}
	public Pedido salvaPedido(Pedido Pedido) {
		return pedidoRepository.save(Pedido);
	}
	public Pedido alterarPedido(Long id, Pedido alterarC) {
		Optional <Pedido> existePedido = pedidoRepository.findById(id);
		if(existePedido.isPresent()) {
			alterarC.setId(id);
			return pedidoRepository.save(alterarC);
		}
		return null;
	}
	public boolean apagarPedido(Long id) {
		Optional <Pedido> existeAluno = pedidoRepository.findById(id);
		if (existeAluno.isPresent()) {
			pedidoRepository.deleteById(id);
			return true;
		}
		return false;
		}
	
	}
