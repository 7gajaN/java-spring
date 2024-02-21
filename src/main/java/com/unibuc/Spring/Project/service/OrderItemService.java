package com.unibuc.Spring.Project.service;

import com.unibuc.Spring.Project.exception.order.OrderItemNotFoundException;
import com.unibuc.Spring.Project.model.OrderItem;
import com.unibuc.Spring.Project.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> getAllOrderItems(){
        return orderItemRepository.findAll();
    }

    public OrderItem getOrderItemById(long id){
        Optional<OrderItem> orderItemOptional = orderItemRepository.findById(id);
        if(orderItemOptional.isPresent()){
            return orderItemOptional.get();
        } else {
            throw new OrderItemNotFoundException(id);
        }
    }
}
