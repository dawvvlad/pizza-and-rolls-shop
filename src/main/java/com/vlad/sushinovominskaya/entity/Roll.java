package com.vlad.sushinovominskaya.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Роллы")
@Getter
@Setter
public class Roll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "категория")
    private RollCategory category;

    @Column(name = "название")
    private String name;

    @Column(name = "состав")
    private String composition;

    @Column(name = "цена")
    private Long price;

    public Roll() {}
    public Roll(RollCategory category, String name, String composition, Long price) {
        this.category = category;
        this.name = name;
        this.composition = composition;
        this.price = price;
    }

    public void addRollToCategory(RollCategory category) {
        this.category = category;
        this.category.addRoll(this);
    }
}
