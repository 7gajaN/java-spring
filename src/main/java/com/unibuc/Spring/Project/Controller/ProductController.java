package com.unibuc.Spring.Project.Controller;

import com.unibuc.Spring.Project.model.Product;
import com.unibuc.Spring.Project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/getProductByName")
    public ResponseEntity<String> getProductName(String name){
        Product product = productService.getProductByName(name);
        return ResponseEntity.status(200).body("Product exists");
    }
}
