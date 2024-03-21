package com.relacionamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relacionamento.entities.Produto;
import com.relacionamento.service.produtoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produto")
public class produtoController {
	
	private final produtoService produtoService;

	@Autowired
	public produtoController(produtoService produtoservice) {
		this.produtoService = produtoservice;
	}

	@GetMapping("/{id}")
	@Operation(summary = "Localiza Produto por ID")
	public ResponseEntity<Produto> buscaProdutoControlId(@PathVariable Long id) {
		Produto produto = produtoService.buscaProdutoId(id);
		if (produto != null) {
			return ResponseEntity.ok(produto);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	@Operation(summary = "Apresenta todos os Produto")
	public ResponseEntity<List<Produto>> buscaTodosProdutoControl() {
		List<Produto> Produto = produtoService.buscaTodosProduto();
		return ResponseEntity.ok(Produto);
	}

	@PostMapping
	public ResponseEntity<Produto> salvaProdutoControl(@RequestBody Produto produto) {
		Produto salvaProduto = produtoService.salvaProduto(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaProduto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Produto> alteraProdutoControl(@PathVariable Long id, @RequestBody @Valid Produto Produto) {
		Produto alteraProduto = produtoService.alterarProduto(id, Produto);
		if (alteraProduto != null) {
			return ResponseEntity.ok(Produto);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Produto> apagaProdutoControl(@PathVariable Long id) {
		boolean apagar = produtoService.apagarProduto(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
