package com.vlad.sushinovominskaya.service.order;

import com.vlad.sushinovominskaya.dto.OrderDTO;
import com.vlad.sushinovominskaya.repo.order.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;

    @Autowired
    public OrderServiceImpl(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public void createOrder(OrderDTO order) {
        
    }

    @Override
    public void deleteOrder(Long id) {

    }

    @Override
    public OrderDTO getOrder(Long id) {
        return null;
    }

    @Override
    public OrderDTO getOrder(String phoneNumber) {
        return null;
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return List.of();
    }
}
