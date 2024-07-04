package com.vlad.sushinovominskaya.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "пицца")
@Getter
@Setter
@ToString
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

    @Column(name = "фото")
    private String imagePath;

    public Pizza() {}
    public Pizza(String name, Long size, Long price, String imagePath) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.imagePath = imagePath;
    }
}
