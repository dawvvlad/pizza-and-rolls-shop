package com.vlad.sushinovominskaya.service.pizza;

import com.vlad.sushinovominskaya.dto.PizzaDTO;
import com.vlad.sushinovominskaya.entity.Pizza;
import com.vlad.sushinovominskaya.repo.pizza.PizzaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepo pizzaRepo;

    @Autowired
    public PizzaServiceImpl(PizzaRepo pizzaRepo) {
        this.pizzaRepo = pizzaRepo;
    }

    @Override
    public void createPizza(PizzaDTO pizzaDTO) {
        Pizza pizza = new Pizza(pizzaDTO.getName(), pizzaDTO.getSize(), pizzaDTO.getPrice(), pizzaDTO.getImage());
        pizzaRepo.save(pizza);

        System.out.println(pizza);
    }

    @Override
    public void update(Long id, String name,
                       Long size,
                       Long price,
                       String imagePath) {
        Pizza pizza = pizzaRepo.find(id);
        pizza.setName(name);
        pizza.setSize(size);
        pizza.setPrice(price);
        pizza.setImagePath(imagePath);
        pizzaRepo.update(pizza);
    }

    @Override
    public List<PizzaDTO> findAll() {
        List<Pizza> pizzas = pizzaRepo.findAll();
        List<PizzaDTO> pizzaDTOs = new ArrayList<>();
        for (Pizza pizza : pizzas) {
            pizzaDTOs.add(new PizzaDTO(pizza));
        }
        return pizzaDTOs.isEmpty() ? Collections.emptyList() : pizzaDTOs;
    }

    @Override
    public PizzaDTO findById(Long id) {
        Pizza pizza = pizzaRepo.find(id);
        if (pizza == null) {
            return null;
        } else return new PizzaDTO(pizza);
    }

    @Override
    public PizzaDTO findByName(String name) {
        Pizza pizza = pizzaRepo.find(name);
        if (pizza == null) {
            return null;
        } else return new PizzaDTO(pizza);
    }

    @Override
    public void delete(Long id) {
        Pizza pizza = pizzaRepo.find(id);
        pizzaRepo.delete(pizza);
    }
}
