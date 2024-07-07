package com.vlad.sushinovominskaya.dto;

import com.vlad.sushinovominskaya.entity.Order;
import com.vlad.sushinovominskaya.entity.Pizza;
import com.vlad.sushinovominskaya.entity.Roll;
import com.vlad.sushinovominskaya.entity.RollSet;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OrderDTO {
    private Long id;
    private String customerName;
    private String customerPhone;
    private Long totalPrice;

    private List<RollDTO> rollList = new ArrayList<>();
    private List<RollSetDTO> rollSetList = new ArrayList<>();
    private List<PizzaDTO> pizzaList = new ArrayList<>();

    public OrderDTO(){}
    public OrderDTO(Order order) {
        this.id = order.getId();
        this.customerName = order.getCustomerName();
        this.customerPhone = order.getCustomerPhone();
        this.totalPrice = order.getTotalPrice();

        for (Pizza pizza : order.getPizzaList()) {
            PizzaDTO pizzaDTO = new PizzaDTO(pizza);
            this.pizzaList.add(pizzaDTO);
        }
        for (Roll roll : order.getRollList()) {
            RollDTO rollDTO = new RollDTO(roll);
            this.rollList.add(rollDTO);
        }
        for (RollSet rollSet : order.getRollSetList()) {
            RollSetDTO rollSetDTO = new RollSetDTO(rollSet);
            this.rollSetList.add(rollSetDTO);
        }
    }

    public void add(Pizza pizza) {
        this.pizzaList.add(new PizzaDTO(pizza));
    }
    public void add(Roll roll) {
        this.rollList.add(new RollDTO(roll));
    }
    public void add(RollSet rollSet) {
        this.rollSetList.add(new RollSetDTO(rollSet));
    }

    public void add(PizzaDTO pizzaDTO) {
        this.pizzaList.add(pizzaDTO);
    }
    public void add(RollDTO rollDTO) {
        this.rollList.add(rollDTO);
    }
    public void add(RollSetDTO rollSetDTO) {
        this.rollSetList.add(rollSetDTO);
    }

}
