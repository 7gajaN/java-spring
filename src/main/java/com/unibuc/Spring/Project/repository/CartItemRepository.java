package com.unibuc.Spring.Project.repository;

import com.unibuc.Spring.Project.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
