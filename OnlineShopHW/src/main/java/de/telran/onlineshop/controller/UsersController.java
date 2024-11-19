package de.telran.onlineshop.controller;

import de.telran.onlineshop.model.RolesEnum;
import de.telran.onlineshop.model.User;
import de.telran.onlineshop.service.UsersService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

    private UsersService usersService;
    @GetMapping(value = "/test")
    String usersGet(){
        return "Привет, я контроллер - UsersController, " + this.toString();
    }

    @PostConstruct
    void init() {
        System.out.println("Run code during creating an object: "
                + this.getClass().getName());
    }

    @GetMapping  //select
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = usersService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.valueOf(200));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = usersService.getUserById(id);
        return ResponseEntity.status(200).body(user);
    }

    // Экранирование кириллицы для url - https://planetcalc.ru/683/
    @GetMapping(value = "/get")
    public ResponseEntity<User> getUserByName(@RequestParam String name) { ///users/get?name=Other,k=2
        User user = usersService.getUserByName(name);
        return ResponseEntity.status(200).body(user);
    }

    @PostMapping //Jackson
    public ResponseEntity<Boolean> createUsers(@RequestBody User newUser) { //insert
        boolean res = usersService.createUser(newUser);
        return ResponseEntity.status(201).body(res);
    }

    @PutMapping
    public ResponseEntity<User> updateUsers(@RequestBody User updUser) { //update
        User user = usersService.updateUser(updUser);
        return ResponseEntity.status(202).body(user);
    }

    @PutMapping
    public ResponseEntity<User> updateClient(@RequestBody User user)  {
        User userResponse = usersService.updateUser(user);
        return ResponseEntity.status(202).body(userResponse);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) { //delete
        User delUser = usersService.getUserById(id);
        return ResponseEntity.status(204).body(delUser);
    }

    @PreDestroy
    public ResponseEntity<Void> destroy() {
        usersService.destroy();
        System.out.println("Run code after finishing work with the object: "
                + this.getClass().getName());
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
