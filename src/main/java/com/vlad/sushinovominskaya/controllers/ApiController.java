package com.vlad.sushinovominskaya.controllers;

import com.vlad.sushinovominskaya.dto.RollCategoryDTO;
import com.vlad.sushinovominskaya.service.category.RollCategoryService;
import com.vlad.sushinovominskaya.service.order.OrderService;
import com.vlad.sushinovominskaya.service.pizza.PizzaService;
import com.vlad.sushinovominskaya.service.roll.RollService;
import com.vlad.sushinovominskaya.service.set.RollSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    private final RollCategoryService rollCategoryService;
    private final RollService rollService;
    private final PizzaService pizzaService;
    private final RollSetService rollSetService;
    private final OrderService orderService;

    @Autowired
    public ApiController(RollCategoryService rollCategoryService,
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

}
