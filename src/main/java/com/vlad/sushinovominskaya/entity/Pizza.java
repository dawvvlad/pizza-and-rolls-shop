package com.vlad.sushinovominskaya.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Пицца")
@Getter
@Setter
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "название")
    private String name;

    @Column(name = "размер")
    private Long size;

    @Column(name = "цена")
    private Long price;

    public Pizza() {}
    public Pizza(String name, Long size, Long price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }
}
