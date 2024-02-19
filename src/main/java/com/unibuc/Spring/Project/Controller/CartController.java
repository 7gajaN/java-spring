package com.unibuc.Spring.Project.Controller;

import com.unibuc.Spring.Project.dto.user.cart.AddToCartRequest;
import com.unibuc.Spring.Project.dto.user.cart.ClearCartRequest;
import com.unibuc.Spring.Project.dto.user.cart.RemoveProductFromCartRequest;
import com.unibuc.Spring.Project.model.Product;
import com.unibuc.Spring.Project.model.User;
import com.unibuc.Spring.Project.service.CartService;
import com.unibuc.Spring.Project.service.ProductService;
import com.unibuc.Spring.Project.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<?> addToCart(@RequestBody @Valid AddToCartRequest addToCartRequest){
        User user = userService.getUserByUsername(addToCartRequest.getUsername());
        Product product = productService.getProductByName(addToCartRequest.getProductName());

        cartService.addToCart(user, product);
        return ResponseEntity.status(200).body("Product " + product.getName() + " was added in " + user.getUsername() + "'s cart");
    }

    @PutMapping
    public ResponseEntity<?> clearCart(@RequestBody @Valid ClearCartRequest clearCartRequest){
        User user = userService.getUserByUsername(clearCartRequest.getUsername());
        cartService.clearCart(user);
        return ResponseEntity.status(200).body("The cart was cleared");
    }

    @DeleteMapping
    public ResponseEntity<?> removeProductFromCart(@RequestBody @Valid RemoveProductFromCartRequest removeProductFromCartRequest){
        User user = userService.getUserByUsername(removeProductFromCartRequest.getUsername());
        Product product = productService.getProductByName(removeProductFromCartRequest.getProductName());

        cartService.removeProductFromCart(user,product);

        return ResponseEntity.status(200).body("Product " + product.getName() + " was removed from the cart");
    }

}
