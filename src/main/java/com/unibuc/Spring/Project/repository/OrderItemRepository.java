package com.unibuc.Spring.Project.repository;

import com.unibuc.Spring.Project.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
