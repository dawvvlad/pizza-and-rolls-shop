package com.vlad.sushinovominskaya.controllers;

import com.vlad.sushinovominskaya.dto.*;
import com.vlad.sushinovominskaya.service.category.RollCategoryService;
import com.vlad.sushinovominskaya.service.order.OrderCreateRequest;
import com.vlad.sushinovominskaya.service.order.OrderService;
import com.vlad.sushinovominskaya.service.pizza.PizzaService;
import com.vlad.sushinovominskaya.service.roll.RollService;
import com.vlad.sushinovominskaya.service.set.RollSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ApiClientController {

    private final RollCategoryService rollCategoryService;
    private final RollService rollService;
    private final PizzaService pizzaService;
    private final RollSetService rollSetService;
    private final OrderService orderService;

    @Autowired
    public ApiClientController(RollCategoryService rollCategoryService,
                               PizzaService pizzaService,
                               RollService rollService,
                               RollSetService rollSetService,
                               OrderService orderService) {
        this.rollCategoryService = rollCategoryService;
        this.rollSetService = rollSetService;
        this.pizzaService = pizzaService;
        this.rollService = rollService;
        this.orderService = orderService;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<RollCategoryDTO>> getAllCategories() {
        List<RollCategoryDTO> categories = rollCategoryService.getAllCategories();
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<RollCategoryDTO> getCategory(@PathVariable("id") Long id) {
        RollCategoryDTO rollCategoryDTO = rollCategoryService.getCategoryById(id);
        return ResponseEntity.status(HttpStatus.OK).body(rollCategoryDTO);
    }

    @GetMapping("/rolls")
    public ResponseEntity<List<RollDTO>> getAllRolls() {
        List<RollDTO> list = rollService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/rolls/{id}")
    public ResponseEntity<RollDTO> getRoll(@PathVariable("id") Long id) {
        RollDTO rollDTO = rollService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(rollDTO);
    }

    @GetMapping("/pizza")
    public ResponseEntity<List<PizzaDTO>> getAllPizza() {
        List<PizzaDTO> list = pizzaService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/pizza/{id}")
    public ResponseEntity<PizzaDTO> getPizza(@PathVariable("id") Long id) {
        PizzaDTO pizzaDTO = pizzaService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(pizzaDTO);
    }

    @GetMapping("/sets")
    public ResponseEntity<List<RollSetDTO>> getAllSets() {
        List<RollSetDTO> list = rollSetService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/sets/{id}")
    public ResponseEntity<RollSetDTO> getSet(@PathVariable("id") Long id) {
        RollSetDTO rollSetDTO = rollSetService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(rollSetDTO);
    }

    @PostMapping("createOrder")
    public ResponseEntity<OrderCreateRequest> createOrder(@RequestBody OrderCreateRequest ohr) {
        orderService.createOrder(ohr);
        return ResponseEntity.status(HttpStatus.CREATED).body(ohr);
    }

}
