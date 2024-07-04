package com.vlad.sushinovominskaya.service.order;

import com.vlad.sushinovominskaya.dto.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    void createOrder(String customerName,
                     String customerPhone,
                     Long totalPrice,
                     List<Long> pizzaList,
                     List<Long> rollList,
                     List<Long> rollSetList);
    void deleteOrder(Long id);
    OrderDTO getOrder(Long id);
    OrderDTO getOrder(String phoneNumber);
    List<OrderDTO> getAllOrders();
}
