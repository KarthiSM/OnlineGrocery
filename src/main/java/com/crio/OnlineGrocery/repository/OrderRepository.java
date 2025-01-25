package com.crio.OnlineGrocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crio.OnlineGrocery.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}