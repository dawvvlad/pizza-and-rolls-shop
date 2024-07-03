package com.vlad.sushinovominskaya.dto;

import com.vlad.sushinovominskaya.entity.Pizza;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PizzaDTO {
    private Long id;
    private String name;
    private Long size;
    private Long price;

    public PizzaDTO() {}
    public PizzaDTO(Long id, String name, Long size, Long price) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.price = price;
    }
    public PizzaDTO(Pizza pizza) {
        this.id = pizza.getId();
        this.name = pizza.getName();
        this.size = pizza.getSize();
        this.price = pizza.getPrice();
    }
}
