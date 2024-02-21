package com.unibuc.Spring.Project.Controller;

import com.unibuc.Spring.Project.dto.product.CreateProductRequest;
import com.unibuc.Spring.Project.dto.product.DeleteProductRequest;
import com.unibuc.Spring.Project.dto.product.GetProductByNameRequest;
import com.unibuc.Spring.Project.exception.product.ProductAlreadyExistsException;
import com.unibuc.Spring.Project.model.Product;
import com.unibuc.Spring.Project.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> productList = productService.getAllProducts();

        return ResponseEntity.status(200).body(productList);
    }

    @GetMapping
    public ResponseEntity<Product> getProductByName(@RequestBody @Valid GetProductByNameRequest getProductByNameRequest){
        Product product = productService.getProductByName(getProductByNameRequest.getProductName());

        return ResponseEntity.status(200).body(product);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody @Valid CreateProductRequest createProductRequest) {
        if (!productService.exists(createProductRequest.getProductName())) {
            Product product = new Product();
            product.setName(createProductRequest.getProductName());
            product.setPrice(createProductRequest.getPrice());

            productService.createProduct(product);
        } else {
            throw new ProductAlreadyExistsException();
        }
        return null;
    }

    @DeleteMapping
    public ResponseEntity<String> deleteProduct(@RequestBody @Valid DeleteProductRequest deleteProductRequest){
        Product product = productService.getProductByName(deleteProductRequest.getProductName());

        productService.deleteProduct(product);

        return ResponseEntity.status(200).body("Product was deleted!");
    }

}
