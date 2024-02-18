package com.unibuc.Spring.Project.Controller;

import com.unibuc.Spring.Project.model.OrderItem;
import com.unibuc.Spring.Project.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/orderitems")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    public List<OrderItem> getAllOrderItems(){
        return orderItemService.getAllOrderItems();
    }
}
