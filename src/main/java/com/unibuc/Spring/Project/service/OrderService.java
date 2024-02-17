package com.unibuc.Spring.Project.service;

import com.unibuc.Spring.Project.exception.OrderNotFoundException;
import com.unibuc.Spring.Project.model.Order;
import com.unibuc.Spring.Project.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order getOrderById(long id){
        Optional<Order> orderOptional = orderRepository.findById(id);
        if(orderOptional.isPresent()){
            return orderOptional.get();
        } else {
            throw new OrderNotFoundException(id);
        }
    }
}
