package com.unibuc.Spring.Project.service;

import com.unibuc.Spring.Project.model.*;
import com.unibuc.Spring.Project.repository.CartRepository;
import com.unibuc.Spring.Project.repository.OrderRepository;
import com.unibuc.Spring.Project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository  cartRepository;
    @Autowired
    private OrderRepository orderRepository;


    public void createCart(User user){
        Cart cart = new Cart(user);
        cartRepository.save(cart);
    }

    public Cart getUserCart(User user){
        return cartRepository.getReferenceById(user.getId());
    }

    public void addToCart(User user, Product product){
        Cart cart = getUserCart(user);
        if(cart == null){
            createCart(user);
            cart = getUserCart(user);
        }

        List<OrderItem> itemList = cart.getOrderItems();
        OrderItem item = new OrderItem(cart, product, 1);
        itemList.add(item);
        cart.setOrderItems(itemList);

        cartRepository.save(cart);
    }

    public void removeProductFromCart(User user, Product product){
        Cart cart = getUserCart(user);
        if(cart == null){
            createCart(user);
            cart = getUserCart(user);
        }

        List<OrderItem> orderItems = cart.getOrderItems();

        for(OrderItem i : orderItems){
            if(i.getProduct().equals(product)){
                orderItems.remove(i);
                break;
            }
        }
    }

    public void clearCart(User user){
        Cart cart = cartRepository.getReferenceById(user.getId());
        cartRepository.delete(cart);
    }

    public void goCheckout(User user){
        Cart cart = getUserCart(user);
        orderRepository.save(cart);
        cartRepository.delete(cart);
    }


}
