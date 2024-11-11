package de.telran.onlineshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductsController {
    @GetMapping
    String cartGet(){
        return "Привет, я контроллер - ProductsController, " + this.toString();
    }
}
