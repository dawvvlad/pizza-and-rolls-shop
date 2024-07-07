package com.vlad.sushinovominskaya.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "заказы")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "номер_заказа")
    private Long id;

    @Column(name = "Имя")
    private String customerName;

    @Column(name = "номер_телефона")
    private String customerPhone;

    @Column(name = "сумма_заказа")
    private Long totalPrice;

    @ManyToMany(cascade = {CascadeType.PERSIST,
            CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.REFRESH})
    @JoinTable(
            name = "заказ_инфо",
            joinColumns = @JoinColumn(name = "номер_заказа"),
            inverseJoinColumns = @JoinColumn(name = "роллы")
    )
    List<Roll> rollList = null;

    @ManyToMany(cascade = {CascadeType.PERSIST,
            CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.REFRESH})
    @JoinTable(
            name = "заказ_инфо",
            joinColumns = @JoinColumn(name = "номер_заказа"),
            inverseJoinColumns = @JoinColumn(name = "сеты")
    )
    List<RollSet> rollSetList = null;

    @ManyToMany(cascade = {CascadeType.PERSIST,
            CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.REFRESH})
    @JoinTable(
            name = "заказ_инфо",
            joinColumns = @JoinColumn(name = "номер_заказа"),
            inverseJoinColumns = @JoinColumn(name = "пицца")
    )
    List<Pizza> pizzaList = null;

    public Order() {}
    public Order(String customerName, String customerPhone, Long totalPrice) {
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.totalPrice = totalPrice;
    }

    public void addPizza(Pizza pizza) {
        if (pizzaList == null) {
            pizzaList = new ArrayList<>();
        }
        pizzaList.add(pizza);
    }
    public void addRoll(Roll roll) {
        if (rollList == null) {
            rollList = new ArrayList<>();
        }
        rollList.add(roll);
    }
    public void addSet(RollSet rollSet) {
        if (rollSetList == null) {
            rollSetList = new ArrayList<>();
        }
        rollSetList.add(rollSet);
    }
}
