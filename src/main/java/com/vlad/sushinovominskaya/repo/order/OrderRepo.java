package com.vlad.sushinovominskaya.repo.order;

import com.vlad.sushinovominskaya.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo {
    void save(Order order);
    void delete(Order order);
    List<Order> findAll();
    Order find(Long id);
}
