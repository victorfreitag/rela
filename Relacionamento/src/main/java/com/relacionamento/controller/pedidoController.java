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

import com.relacionamento.entities.Pedido;
import com.relacionamento.service.pedidoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pedido")
public class pedidoController {
	
	private final pedidoService pedidoService;

	@Autowired
	public pedidoController(pedidoService pedidoservice) {
		this.pedidoService = pedidoservice;
	}

	@GetMapping("/{id}")
	@Operation(summary = "Localiza Pedido por ID")
	public ResponseEntity<Pedido> buscaPedidoControlId(@PathVariable Long id) {
		Pedido pedido = pedidoService.buscaPedidoId(id);
		if (pedido != null) {
			return ResponseEntity.ok(pedido);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	@Operation(summary = "Apresenta todos os Pedido")
	public ResponseEntity<List<Pedido>> buscaTodosPedidoControl() {
		List<Pedido> Pedido = pedidoService.buscaTodosPedido();
		return ResponseEntity.ok(Pedido);
	}

	@PostMapping
	public ResponseEntity<Pedido> salvaPedidoControl(@RequestBody Pedido pedido) {
		Pedido salvaPedido = pedidoService.salvaPedido(pedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaPedido);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pedido> alteraPedidoControl(@PathVariable Long id, @RequestBody @Valid Pedido Pedido) {
		Pedido alteraPedido = pedidoService.alterarPedido(id, Pedido);
		if (alteraPedido != null) {
			return ResponseEntity.ok(Pedido);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Pedido> apagaPedidoControl(@PathVariable Long id) {
		boolean apagar = pedidoService.apagarPedido(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
