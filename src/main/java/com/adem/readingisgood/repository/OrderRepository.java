package com.adem.readingisgood.repository;

import com.adem.readingisgood.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCreatedDateBetween(Date createdDateStart, Date createdDateEnd);
}
