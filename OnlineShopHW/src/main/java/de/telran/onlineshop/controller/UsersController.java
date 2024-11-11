package de.telran.onlineshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UsersController {
    @GetMapping
    String usersGet(){
        return "Привет, я контроллер - UsersController, " + this.toString();
    }
}
