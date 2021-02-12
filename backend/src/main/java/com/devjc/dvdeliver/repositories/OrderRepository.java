package com.devjc.dvdeliver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devjc.dvdeliver.entities.Order; 

public interface OrderRepository extends JpaRepository<Order, Long> {

}
