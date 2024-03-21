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

import com.relacionamento.entities.ItemPedido;
import com.relacionamento.service.itemPedidoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/itemItemPedido")
public class itemPedidoController {
	
	private final itemPedidoService itemPedidoService;

	@Autowired
	public itemPedidoController(itemPedidoService itemPedidoService) {
		this.itemPedidoService = itemPedidoService;
	}

	@GetMapping("/{id}")
	@Operation(summary = "Localiza ItemPedido por ID")
	public ResponseEntity<ItemPedido> buscaItemPedidoControlId(@PathVariable Long id) {
		ItemPedido itemItemPedido = itemPedidoService.buscaItemPedidoId(id);
		if (itemItemPedido != null) {
			return ResponseEntity.ok(itemItemPedido);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	@Operation(summary = "Apresenta todos os ItemPedido")
	public ResponseEntity<List<ItemPedido>> buscaTodosItemPedidoControl() {
		List<ItemPedido> ItemPedido = itemPedidoService.buscaTodosItemPedido();
		return ResponseEntity.ok(ItemPedido);
	}

	@PostMapping
	public ResponseEntity<ItemPedido> salvaItemPedidoControl(@RequestBody ItemPedido itemItemPedido) {
		ItemPedido salvaItemPedido = itemPedidoService.salvaItemPedido(itemItemPedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaItemPedido);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ItemPedido> alteraItemPedidoControl(@PathVariable Long id, @RequestBody @Valid ItemPedido ItemPedido) {
		ItemPedido alteraItemPedido = itemPedidoService.alterarItemPedido(id, ItemPedido);
		if (alteraItemPedido != null) {
			return ResponseEntity.ok(ItemPedido);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ItemPedido> apagaItemPedidoControl(@PathVariable Long id) {
		boolean apagar = itemPedidoService.apagarItemPedido(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
