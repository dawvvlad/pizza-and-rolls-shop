package com.vlad.sushinovominskaya.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "роллы")
@Getter
@Setter
public class Roll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "категория")
    private RollCategory category;

    @Column(name = "название")
    private String name;

    @Column(name = "состав")
    private String composition;

    @Column(name = "цена")
    private Long price;

    @Column(name = "фото")
    private String imagePath;

    public Roll() {}
    public Roll(RollCategory category, String name, String composition, Long price, String imagePath) {
        this.category = category;
        this.name = name;
        this.composition = composition;
        this.price = price;
        this.imagePath = imagePath;
    }

    public void addRollToCategory(RollCategory category) {
        this.category = category;
        this.category.addRoll(this);
    }
}
