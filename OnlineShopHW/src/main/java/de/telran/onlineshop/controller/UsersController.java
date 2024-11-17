package de.telran.onlineshop.controller;

import de.telran.onlineshop.model.RolesEnum;
import de.telran.onlineshop.model.Users;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

    private List<Users> usersList;
    @GetMapping(value = "/test")
    String usersGet(){
        return "Привет, я контроллер - UsersController, " + this.toString();
    }

    @PostConstruct
    void init() {
        usersList = new ArrayList<>();

        usersList.add(new Users(1, "User1", "user1@yahoo.com", "+1234561", "", RolesEnum.ADMINISTRATOR));
        usersList.add(new Users(2, "User2", "user2@yahoo.com", "+1234562", "", RolesEnum.CLIENT));
        usersList.add(new Users(3, "User3", "user3@yahoo.com", "+1234563", "", RolesEnum.CLIENT));
        usersList.add(new Users(4, "User4", "user4@yahoo.com", "+1234564", "", RolesEnum.CLIENT));
        usersList.add(new Users(5, "User5", "user5@yahoo.com", "+1234565", "", RolesEnum.CLIENT));

        System.out.println("Run code during creating an object: "
                + this.getClass().getName());
    }

    @GetMapping  //select
    List<Users> getAllUsers() {
        return usersList;
    }

    @GetMapping(value = "/find/{id}")
    Users getUserById(@PathVariable Long id) { ///users/find/3
        return usersList.stream()
                .filter(category -> category.getUserId()==id)
                .findFirst()
                .orElse(null);
    }

    // Экранирование кириллицы для url - https://planetcalc.ru/683/
    @GetMapping(value = "/get")
    Users getUserByName(@RequestParam String name) { ///users/get?name=Other,k=2
        return usersList.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @PostMapping //Jackson
    public boolean createUsers(@RequestBody Users newUser) { //insert
        return usersList.add(newUser);
    }

    @PutMapping
    public Users updateUsers(@RequestBody Users updUser) { //update
        Users result = usersList.stream()
                .filter(user -> user.getUserId() == updUser.getUserId())
                .findFirst()
                .orElse(null);
        if(result!=null) {
            result.setName(updUser.getName());
        }
        return result;
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUsers(@PathVariable Long id) { //delete
        Iterator<Users> it = usersList.iterator();
        while (it.hasNext()) {
            Users current = it.next();
            if(current.getUserId()==id) {
                it.remove();
            }
        }
    }

    @PreDestroy
    void destroy() {
        usersList.clear();
        System.out.println("Run code after finishing work with the object: "
                + this.getClass().getName());
    }

}
