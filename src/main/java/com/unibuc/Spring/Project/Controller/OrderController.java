package com.unibuc.Spring.Project.Controller;


import com.unibuc.Spring.Project.model.Order;
import com.unibuc.Spring.Project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }
}
