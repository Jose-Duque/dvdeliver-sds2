package com.devjc.dvdeliver.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devjc.dvdeliver.dto.OrderDTO;
import com.devjc.dvdeliver.dto.ProductDTO;
import com.devjc.dvdeliver.services.OrderService;
import com.devjc.dvdeliver.services.ProductService;

@RestController
@RequestMapping(value = "/orders") // Definir o caminho do recurso
public class OrderController {

	@Autowired
	private OrderService service;
	
	@GetMapping
	public ResponseEntity<List<OrderDTO>> findAll() {
		List<OrderDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<OrderDTO> insert(@RequestBody OrderDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri ).body(dto);
	}
	
	@PutMapping("/{id}/delivered")
	public ResponseEntity<OrderDTO> updateStatus(@PathVariable Long id) {
		OrderDTO dto = service.updateStatus(id);
		return ResponseEntity.ok().body(dto);
	}
	
}
