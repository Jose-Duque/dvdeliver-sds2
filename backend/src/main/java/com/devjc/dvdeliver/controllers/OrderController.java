package com.devjc.dvdeliver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
