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
    private String image;

    public PizzaDTO() {}
    public PizzaDTO(Long id, String name, Long size, Long price, String image) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.price = price;
        this.image = image;
    }
    public PizzaDTO(Pizza pizza) {
        this.id = pizza.getId();
        this.name = pizza.getName();
        this.size = pizza.getSize();
        this.price = pizza.getPrice();
        this.image = pizza.getImagePath();
    }
}
