package com.vlad.sushinovominskaya.service.order;

import com.vlad.sushinovominskaya.dto.OrderDTO;
import com.vlad.sushinovominskaya.entity.Order;
import com.vlad.sushinovominskaya.entity.Pizza;
import com.vlad.sushinovominskaya.entity.Roll;
import com.vlad.sushinovominskaya.entity.RollSet;
import com.vlad.sushinovominskaya.repo.order.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;

    @Autowired
    public OrderServiceImpl(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }


    @Override
    public void createOrder(String customerName, String customerPhone,
                            Long totalPrice,
                            List<Pizza> pizzaList,
                            List<Roll> rollList,
                            List<RollSet> rollSetList) {
        Order order = new Order(customerName, customerPhone, totalPrice);
        order.setPizzaList(pizzaList);
        order.setRollList(rollList);
        order.setRollSetList(rollSetList);
        orderRepo.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        Order order = orderRepo.find(id);
        orderRepo.delete(order);
    }

    @Override
    public OrderDTO getOrder(Long id) {
        Order order = orderRepo.find(id);
        return new OrderDTO(order);
    }

    @Override
    public OrderDTO getOrder(String phoneNumber) {
        Order order = orderRepo.findByPhoneNumber(phoneNumber);
        return new OrderDTO(order);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepo.findAll();
        List<OrderDTO> orderDTOs = new ArrayList<>();
        for (Order order : orders) {
            orderDTOs.add(new OrderDTO(order));
        }
        return orderDTOs.isEmpty() ? Collections.emptyList() : orderDTOs;
    }
}
