package com.unibuc.Spring.Project.service;

import com.unibuc.Spring.Project.model.CartItem;
import com.unibuc.Spring.Project.repository.CartItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {
    private CartItemRepository cartItemRepository;

    public List<CartItem> getAllOrderItems(){
        return cartItemRepository.findAll();
    }
}
