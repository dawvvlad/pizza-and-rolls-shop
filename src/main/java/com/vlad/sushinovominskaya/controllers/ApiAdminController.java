package com.vlad.sushinovominskaya.controllers;

import com.vlad.sushinovominskaya.dto.*;
import com.vlad.sushinovominskaya.service.category.RollCategoryService;
import com.vlad.sushinovominskaya.service.order.OrderService;
import com.vlad.sushinovominskaya.service.pizza.PizzaService;
import com.vlad.sushinovominskaya.service.roll.RollService;
import com.vlad.sushinovominskaya.service.set.RollSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class ApiAdminController {

    private final OrderService orderService;
    private final RollCategoryService rollCategoryService;
    private final PizzaService pizzaService;
    private final RollService rollService;
    private final RollSetService rollSetService;

    @Autowired
    public ApiAdminController(OrderService orderService,
                              RollCategoryService rollCategoryService,
                              PizzaService pizzaService,
                              RollService rollService,
                              RollSetService rollSetService) {
        this.orderService = orderService;
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

    @PatchMapping("/updatePizza/{id}")
    public ResponseEntity<PizzaDTO> updatePizza(@PathVariable Long id, @RequestBody PizzaDTO pizzaDTO) {
        pizzaService.update(id, pizzaDTO);
        return ResponseEntity.status(HttpStatus.OK).body(pizzaDTO);
    }

    @PatchMapping("/updateRoll/{id}")
    public ResponseEntity<RollDTO> updateRoll(@PathVariable("id") Long id, @RequestBody RollDTO rollDTO) {
        rollService.update(id, rollDTO);
        return ResponseEntity.status(HttpStatus.OK).body(rollDTO);
    }

    @PatchMapping("/updateSet/{id}")
    public ResponseEntity<RollSetDTO> updateSet(@PathVariable("id") Long id, @RequestBody RollSetDTO rollSetDTO) {
        rollSetService.update(id, rollSetDTO);
        return ResponseEntity.status(HttpStatus.OK).body(rollSetDTO);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderDTO>> getOrders() {
        List<OrderDTO> list = orderService.getAllOrders();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

}
