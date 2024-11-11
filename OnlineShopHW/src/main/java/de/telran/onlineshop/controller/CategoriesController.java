package de.telran.onlineshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categories")
public class CategoriesController {
    @GetMapping
    String cartGet(){
        return "Привет, я контроллер - CategoriesController, " + this.toString();
    }
}
