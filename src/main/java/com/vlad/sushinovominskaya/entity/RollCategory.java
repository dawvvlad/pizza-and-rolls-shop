package com.vlad.sushinovominskaya.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "КатегорииРоллов")
@Setter
@Getter
public class RollCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "название")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Roll> rolls;

    public RollCategory() {}
    public RollCategory(String name) {
        this.name = name;
    }

    public RollCategory(String name, List<Roll> rolls) {
        this.name = name;
        this.rolls = rolls;
    }

    public void addRoll(Roll roll) {
        if(this.rolls == null) {
            this.rolls = new ArrayList<>();
        }
        rolls.add(roll);
    }
}
