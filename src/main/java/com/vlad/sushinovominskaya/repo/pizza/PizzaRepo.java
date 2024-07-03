package com.vlad.sushinovominskaya.repo.pizza;

import com.vlad.sushinovominskaya.entity.Pizza;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaRepo {
    Pizza save(Pizza pizza);
    void delete(Pizza pizza);
    List<Pizza> findAll();
    Pizza find(Long id);
    Pizza find(String name);
}
