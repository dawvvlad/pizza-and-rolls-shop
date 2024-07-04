package com.vlad.sushinovominskaya.service.order;

import com.vlad.sushinovominskaya.dto.OrderDTO;
import com.vlad.sushinovominskaya.entity.Order;
import com.vlad.sushinovominskaya.entity.Pizza;
import com.vlad.sushinovominskaya.entity.Roll;
import com.vlad.sushinovominskaya.entity.RollSet;
import com.vlad.sushinovominskaya.repo.order.OrderRepo;
import com.vlad.sushinovominskaya.repo.pizza.PizzaRepo;
import com.vlad.sushinovominskaya.repo.roll.RollRepo;
import com.vlad.sushinovominskaya.repo.set.RollSetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final PizzaRepo pizzaRepo;
    private final RollRepo rollRepo;
    private final RollSetRepo rollSetRepo;

    @Autowired
    public OrderServiceImpl(OrderRepo orderRepo, RollRepo rollRepo, RollSetRepo rollSetRepo, PizzaRepo pizzaRepo) {
        this.orderRepo = orderRepo;
        this.rollRepo = rollRepo;
        this.rollSetRepo = rollSetRepo;
        this.pizzaRepo = pizzaRepo;
    }


    @Override
    public void createOrder(String customerName, String customerPhone,
                            Long totalPrice,
                            List<Long> pizzaIds,
                            List<Long> rollIds,
                            List<Long> rollSetIds) {
        Order order = new Order(customerName, customerPhone, totalPrice);

        for (Long pizzaId : pizzaIds) {
            Pizza pizza = pizzaRepo.find(pizzaId);
            order.addPizza(pizza);
        }
        for (Long rollId : rollIds) {
            Roll roll = rollRepo.find(rollId);
            order.addRoll(roll);
        }
        for (Long rollSetId : rollSetIds) {
            RollSet rollSet = rollSetRepo.find(rollSetId);
            order.addSet(rollSet);
        }
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
