package com.vlad.sushinovominskaya.service.order;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderCreateRequest {
    private String customerName;
    private String customerPhone;
    private Long totalPrice;

    private List<Long> rollList;
    private List<Long> rollSetList;
    private List<Long> pizzaList;
    public OrderCreateRequest() {}
}

