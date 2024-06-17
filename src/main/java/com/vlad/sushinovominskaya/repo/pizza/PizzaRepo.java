package com.vlad.sushinovominskaya.repo.pizza;

import com.vlad.sushinovominskaya.entity.Pizza;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepo {
    void persist(Pizza pizza);
}
