package de.telran.onlineshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/favorites")
public class FavoritesController {
    @GetMapping
    String favoritesGet(){
        return "Привет, я контроллер - FavoritesController, " + this.toString();
    }
}
