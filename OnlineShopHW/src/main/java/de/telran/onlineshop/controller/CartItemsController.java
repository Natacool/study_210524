package de.telran.onlineshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cart_items")
public class CartItemsController {
    @GetMapping
    String cartItemsGet(){
        return "Привет, я контроллер - CartItemsController, " + this.toString();
    }
}
