package com.crio.OnlineGrocery.service;

import java.util.List;

import com.crio.OnlineGrocery.dto.OrderRequest;
import com.crio.OnlineGrocery.model.Order;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order createOrder(OrderRequest orderRequest);
    void deleteOrder(Long id);
}
