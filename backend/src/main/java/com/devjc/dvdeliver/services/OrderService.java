package com.devjc.dvdeliver.services;

import java.time.Instant;
import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devjc.dvdeliver.dto.OrderDTO;
import com.devjc.dvdeliver.dto.ProductDTO;
import com.devjc.dvdeliver.entities.Order;
import com.devjc.dvdeliver.entities.OrderStatus;
import com.devjc.dvdeliver.entities.Product;
import com.devjc.dvdeliver.repositories.OrderRepository;
import com.devjc.dvdeliver.repositories.ProductRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll() {
		List<Order> list = repository.findOrdersWithProducts();
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList()); 
	}
	
	@Transactional
	public OrderDTO insert(OrderDTO dto) {
		Order order = new Order(null, dto.getAddress(),dto.getLatitude(),dto.getLatitude(),Instant.now(),OrderStatus.PENDING);
		for(ProductDTO p : dto.getProducts()) {
			Product product = productRepository.getOne(p.getId());
			order.getProducts().add(product);
		}
		order = repository.save(order);
		return new OrderDTO(order);
	}
	
	@Transactional
	public OrderDTO updateStatus(Long id) {
		Order order = repository.getOne(id);
		order.setStatus(OrderStatus.DELIVERED);
		return new OrderDTO(order);
	}
}
