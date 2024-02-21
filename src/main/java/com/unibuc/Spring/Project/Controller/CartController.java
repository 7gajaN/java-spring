package com.unibuc.Spring.Project.Controller;

import com.unibuc.Spring.Project.dto.user.cart.AddToCartRequest;
import com.unibuc.Spring.Project.dto.user.cart.CheckoutRequest;
import com.unibuc.Spring.Project.dto.user.cart.ClearCartRequest;
import com.unibuc.Spring.Project.dto.user.cart.RemoveProductFromCartRequest;
import com.unibuc.Spring.Project.model.Cart;
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
    public ResponseEntity<Cart> addToCart(@RequestBody @Valid AddToCartRequest addToCartRequest){
        User user = userService.getUserByUsername(addToCartRequest.getUsername());
        Product product = productService.getProductByName(addToCartRequest.getProductName());

        Cart cart = cartService.addToCart(user, product);
        return ResponseEntity.status(200).body(cart);
    }

    @PutMapping
    public ResponseEntity<String> clearCart(@RequestBody @Valid ClearCartRequest clearCartRequest){
        User user = userService.getUserByUsername(clearCartRequest.getUsername());
        cartService.clearCart(user);
        return ResponseEntity.status(200).body("The cart was cleared");
    }

    @DeleteMapping
    public ResponseEntity<Cart> removeProductFromCart(@RequestBody @Valid RemoveProductFromCartRequest removeProductFromCartRequest){
        User user = userService.getUserByUsername(removeProductFromCartRequest.getUsername());
        Product product = productService.getProductByName(removeProductFromCartRequest.getProductName());

        Cart cart = cartService.removeProductFromCart(user,product);

        return ResponseEntity.status(200).body(cart);
    }

    @PostMapping("/checkout")
    public ResponseEntity<?> checkout(@RequestBody @Valid CheckoutRequest checkoutRequest){
        User user = userService.getUserByUsername(checkoutRequest.getUsername());

        cartService.goCheckout(user);
        return ResponseEntity.status(200).body("The order has been placed");
    }

}
