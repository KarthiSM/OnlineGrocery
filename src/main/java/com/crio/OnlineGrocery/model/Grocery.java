package com.crio.OnlineGrocery.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Grocery")
@Data
public class Grocery {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String category;
    private Double price;
    private Long quantity;
}