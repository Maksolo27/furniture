package com.example.order.repository;

import com.example.order.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>, CrudRepository<Order,Long> {
}
