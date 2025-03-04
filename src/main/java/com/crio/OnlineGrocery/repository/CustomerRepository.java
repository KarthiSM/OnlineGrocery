package com.crio.OnlineGrocery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crio.OnlineGrocery.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
    List<Customer> findByEmail(String email);

} 