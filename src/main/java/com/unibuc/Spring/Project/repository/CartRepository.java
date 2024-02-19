package com.unibuc.Spring.Project.repository;

import com.unibuc.Spring.Project.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
