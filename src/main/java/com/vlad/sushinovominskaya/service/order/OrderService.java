package com.vlad.sushinovominskaya.service.order;

import com.vlad.sushinovominskaya.dto.OrderDTO;
import com.vlad.sushinovominskaya.entity.Pizza;
import com.vlad.sushinovominskaya.entity.Roll;
import com.vlad.sushinovominskaya.entity.RollSet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    void createOrder(String customerName,
                     String customerPhone,
                     Long totalPrice,
                     List<Pizza> pizzaList,
                     List<Roll> rollList,
                     List<RollSet> rollSetList);
    void deleteOrder(Long id);
    OrderDTO getOrder(Long id);
    OrderDTO getOrder(String phoneNumber);
    List<OrderDTO> getAllOrders();
}
