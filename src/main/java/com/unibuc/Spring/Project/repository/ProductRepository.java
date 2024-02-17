package com.unibuc.Spring.Project.repository;

import com.unibuc.Spring.Project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
