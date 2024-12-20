package de.telran.onlineshop.controller;

import de.telran.onlineshop.dto.UserDto;
import de.telran.onlineshop.service.UsersService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = usersService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.valueOf(200));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto user = usersService.getUserById(id);
        return ResponseEntity.status(222).body(user);
    }

    // Экранирование кириллицы для url - https://planetcalc.ru/683/
    @GetMapping(value = "/get")
    public ResponseEntity<UserDto> getUserByName(@RequestParam String name) { ///users/get?name=Other,k=2
        UserDto user = usersService.getUserByName(name);
        return ResponseEntity.status(200).body(user);
    }

    @PostMapping //Jackson
    public ResponseEntity<Boolean> createUsers(@RequestBody UserDto newUser) { //insert
        boolean res = usersService.createUser(newUser);
        return ResponseEntity.status(201).body(res);
    }

    @PutMapping
    public ResponseEntity<UserDto> updateUsers(@RequestBody UserDto updUser) { //update
        UserDto user = usersService.updateUser(updUser);
        return ResponseEntity.status(202).body(user);
    }

    @PutMapping
    public ResponseEntity<UserDto> updateClient(@RequestBody UserDto user)  {
        UserDto userResponse = usersService.updateUser(user);
        return ResponseEntity.status(202).body(userResponse);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable Long id) { //delete
        UserDto delUser = usersService.getUserById(id);
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
