package com.relacionamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relacionamento.entities.Fornecedor;
import com.relacionamento.repository.FornecedorRepository;

@Service
public class FornecedorService {
	
	private final FornecedorRepository fornecedorRepository;

	@Autowired
	public FornecedorService(FornecedorRepository fornecedorRepository) {
		this.fornecedorRepository = fornecedorRepository;
	}
	public List<Fornecedor> buscaTodosFornecedor(){
		return fornecedorRepository.findAll();
	}
	public Fornecedor buscaFornecedorId(Long id) {
		Optional <Fornecedor> fornecedor = fornecedorRepository.findById(id);
		return fornecedor.orElse(null);
	}
	public Fornecedor salvaFornecedor(Fornecedor Fornecedor) {
		return fornecedorRepository.save(Fornecedor);
	}
	public Fornecedor alterarFornecedor(Long id, Fornecedor alterarC) {
		Optional <Fornecedor> existeFornecedor = fornecedorRepository.findById(id);
		if(existeFornecedor.isPresent()) {
			alterarC.setId(id);
			return fornecedorRepository.save(alterarC);
		}
		return null;
	}
	public boolean apagarFornecedor(Long id) {
		Optional <Fornecedor> existeAluno = fornecedorRepository.findById(id);
		if (existeAluno.isPresent()) {
			fornecedorRepository.deleteById(id);
			return true;
		}
		return false;
		}
	
	}
