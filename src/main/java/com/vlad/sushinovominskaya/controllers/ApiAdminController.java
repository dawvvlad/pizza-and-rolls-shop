package com.vlad.sushinovominskaya.controllers;

import com.vlad.sushinovominskaya.dto.PizzaDTO;
import com.vlad.sushinovominskaya.dto.RollCategoryDTO;
import com.vlad.sushinovominskaya.dto.RollDTO;
import com.vlad.sushinovominskaya.dto.RollSetDTO;
import com.vlad.sushinovominskaya.service.category.RollCategoryService;
import com.vlad.sushinovominskaya.service.pizza.PizzaService;
import com.vlad.sushinovominskaya.service.roll.RollService;
import com.vlad.sushinovominskaya.service.set.RollSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class ApiAdminController {

    private final RollCategoryService rollCategoryService;
    private final PizzaService pizzaService;
    private final RollService rollService;
    private final RollSetService rollSetService;

    @Autowired
    public ApiAdminController(RollCategoryService rollCategoryService,
                              PizzaService pizzaService,
                              RollService rollService,
                              RollSetService rollSetService) {
        this.rollCategoryService = rollCategoryService;
        this.pizzaService = pizzaService;
        this.rollService = rollService;
        this.rollSetService = rollSetService;
    }

    @PostMapping("/createCategory")
    public void createCategory(@RequestBody RollCategoryDTO categoryDTO) {
        rollCategoryService.createCategory(categoryDTO.getName());
        System.out.println("Категория создана: " + categoryDTO.getName());
    }

    @PostMapping("/createPizza")
    public ResponseEntity<PizzaDTO> createPizza(@RequestBody PizzaDTO pizzaDTO) {
        pizzaService.createPizza(pizzaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(pizzaDTO);
    }

    @PostMapping("/createRoll")
    public ResponseEntity<RollDTO> createRoll(@RequestBody RollDTO rollDTO) {
        rollService.createRoll(rollDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(rollDTO);
    }

    @PostMapping("/createSet")
    public ResponseEntity<RollSetDTO> createSet(@RequestBody RollSetDTO rollSetDTO) {
        rollSetService.createRollSet(rollSetDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(rollSetDTO);
    }
}
