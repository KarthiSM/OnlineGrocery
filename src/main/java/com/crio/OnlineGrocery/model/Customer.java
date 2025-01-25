package com.crio.OnlineGrocery.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Customer")
@Data
public class Customer {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "Customer_Name")
    private String name;
    private String email;
    private String address;
    private Long phone;

}
