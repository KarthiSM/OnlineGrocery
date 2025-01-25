package com.crio.OnlineGrocery.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "customer_order")
@Data
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime orderDate;

    @ManyToOne
    @JoinColumn(name = "Customer_Id")
    private Customer customer;

    @ManyToMany
    @JoinTable(
        name = "Order_Grocery",
        joinColumns = @JoinColumn(name = "Order_Id"),
        inverseJoinColumns = @JoinColumn(name ="Grovery_Id")
    )

    private List<Grocery> groceries = new ArrayList<>();

}