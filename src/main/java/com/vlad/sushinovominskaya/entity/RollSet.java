package com.vlad.sushinovominskaya.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "сеты")
@Getter
@Setter
public class RollSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "название")
    private String name;

    @Column(name = "цена")
    private Long price;

    @ManyToMany(cascade = {CascadeType.PERSIST,
            CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.REFRESH})
    @JoinTable(
            name = "СоставыСетов",
            joinColumns = @JoinColumn(name = "Сет"),
            inverseJoinColumns = @JoinColumn(name = "Ролл")
    )
    private List<Roll> rolls;

    public RollSet() {}
    public RollSet(String name, Long price) {
        this.name = name;
        this.price = price;
    }

    public void addRollToSet(Roll roll) {
        if (rolls == null) {
            rolls = new ArrayList<>();
        }
        this.rolls.add(roll);
    }
}
