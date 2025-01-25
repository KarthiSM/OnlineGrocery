package com.crio.OnlineGrocery.service.implementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.OnlineGrocery.dto.OrderRequest;
import com.crio.OnlineGrocery.exception.ResourceNotFoundException;
import com.crio.OnlineGrocery.model.Customer;
import com.crio.OnlineGrocery.model.Order;
import com.crio.OnlineGrocery.model.Grocery;
import com.crio.OnlineGrocery.repository.CustomerRepository;
import com.crio.OnlineGrocery.repository.OrderRepository;
import com.crio.OnlineGrocery.repository.GroceryRepository;
import com.crio.OnlineGrocery.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private GroceryRepository groceryRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
    }

    @Override
    public Order createOrder(OrderRequest orderRequest) {
        Customer customer = customerRepository.findById(orderRequest.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + orderRequest.getCustomerId()));
        List<Grocery> groceries = groceryRepository.findAllById(orderRequest.getGroceryIds());
        
        if (groceries.size() != orderRequest.getGroceryIds().size()) {
            throw new ResourceNotFoundException("One or more groceries not found");
        }

        Order order = new Order();

        order.setCustomer(customer);
        order.setGroceries(groceries);
        order.setOrderDate(LocalDateTime.now());
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        Order order = getOrderById(id);
        orderRepository.delete(order);
    }
}