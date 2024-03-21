package com.relacionamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relacionamento.entities.ItemPedido;
import com.relacionamento.repository.itemPedidoRepository;

@Service
public class itemPedidoService {
	
	private final itemPedidoRepository itemPedidoRepository;

	@Autowired
	public itemPedidoService(itemPedidoRepository itemPedidoRepository) {
		this.itemPedidoRepository = itemPedidoRepository;
	}
	public List<ItemPedido> buscaTodosItemPedido(){
		return itemPedidoRepository.findAll();
	}
	public ItemPedido buscaItemPedidoId(Long id) {
		Optional <ItemPedido> itemPedido = itemPedidoRepository.findById(id);
		return itemPedido.orElse(null);
	}
	public ItemPedido salvaItemPedido(ItemPedido ItemPedido) {
		return itemPedidoRepository.save(ItemPedido);
	}
	public ItemPedido alterarItemPedido(Long id, ItemPedido alterarC) {
		Optional <ItemPedido> existeItemPedido = itemPedidoRepository.findById(id);
		if(existeItemPedido.isPresent()) {
			alterarC.setId(id);
			return itemPedidoRepository.save(alterarC);
		}
		return null;
	}
	public boolean apagarItemPedido(Long id) {
		Optional <ItemPedido> existeAluno = itemPedidoRepository.findById(id);
		if (existeAluno.isPresent()) {
			itemPedidoRepository.deleteById(id);
			return true;
		}
		return false;
		}
	
	}
