package com.crio.OnlineGrocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crio.OnlineGrocery.model.Grocery;

public interface GroceryRepository extends JpaRepository<Grocery, Long> {

}