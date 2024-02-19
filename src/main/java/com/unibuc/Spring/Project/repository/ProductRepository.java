package com.unibuc.Spring.Project.repository;

import com.unibuc.Spring.Project.model.Product;
import com.unibuc.Spring.Project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String name);

}
