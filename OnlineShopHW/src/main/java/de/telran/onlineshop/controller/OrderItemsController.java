package de.telran.onlineshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order_items")
public class OrderItemsController {
    @GetMapping
    String orderItemsGet(){
        return "Привет, я контроллер - OrderItemsController, " + this.toString();
    }
}
