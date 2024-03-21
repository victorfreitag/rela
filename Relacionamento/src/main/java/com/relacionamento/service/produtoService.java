package com.relacionamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relacionamento.entities.Produto;
import com.relacionamento.repository.produtoRepository;

@Service
public class produtoService {
	
	private final produtoRepository produtoRepository;

	@Autowired
	public produtoService(produtoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	public List<Produto> buscaTodosProduto(){
		return produtoRepository.findAll();
	}
	public Produto buscaProdutoId(Long id) {
		Optional <Produto> produto = produtoRepository.findById(id);
		return produto.orElse(null);
	}
	public Produto salvaProduto(Produto Produto) {
		return produtoRepository.save(Produto);
	}
	public Produto alterarProduto(Long id, Produto alterarC) {
		Optional <Produto> existeProduto = produtoRepository.findById(id);
		if(existeProduto.isPresent()) {
			alterarC.setId(id);
			return produtoRepository.save(alterarC);
		}
		return null;
	}
	public boolean apagarProduto(Long id) {
		Optional <Produto> existeAluno = produtoRepository.findById(id);
		if (existeAluno.isPresent()) {
			produtoRepository.deleteById(id);
			return true;
		}
		return false;
		}
	
	}
