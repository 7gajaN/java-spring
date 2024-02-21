package com.unibuc.Spring.Project.repository;

import com.unibuc.Spring.Project.model.Order;
import com.unibuc.Spring.Project.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findByUser(User user);

    @Transactional
    void deleteByUser(User user);
}
