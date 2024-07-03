package com.vlad.sushinovominskaya.service.pizza;

import com.vlad.sushinovominskaya.dto.PizzaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PizzaService {
    void save(PizzaDTO pizzaDTO);
    void update(Long id, String name,
                Long size,
                Long price,
                String imagePath);
    List<PizzaDTO> findAll();
    PizzaDTO findById(Long id);
    PizzaDTO findByName(String name);
    void delete(Long id);
}
