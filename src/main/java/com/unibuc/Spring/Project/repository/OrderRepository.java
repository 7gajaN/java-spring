package com.unibuc.Spring.Project.repository;

import com.unibuc.Spring.Project.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
