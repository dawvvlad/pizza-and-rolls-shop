package com.vlad.sushinovominskaya.service.pizza;

import com.vlad.sushinovominskaya.dto.PizzaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PizzaService {
    void createPizza(PizzaDTO pizzaDTO);
    void update(Long id, PizzaDTO pizzaDTO);
    List<PizzaDTO> findAll();
    PizzaDTO findById(Long id);
    PizzaDTO findByName(String name);
    void delete(Long id);
}
