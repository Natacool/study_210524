package de.telran.onlineshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class OrdersController {
    @GetMapping
    String ordersGet(){
        return "Привет, я контроллер - OrdersController, " + this.toString();
    }
}
