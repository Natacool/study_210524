package de.telran.onlineshop.service;

import de.telran.onlineshop.model.RolesEnum;
import de.telran.onlineshop.model.User;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UsersService {
    private List<User> userList;

    @PostConstruct
    void init() {
        userList = new ArrayList<>();
        userList.add(new User(1, "User1", "user1@yahoo.com", "+1234561", "", RolesEnum.ADMINISTRATOR));
        userList.add(new User(2, "User2", "user2@yahoo.com", "+1234562", "", RolesEnum.CLIENT));
        userList.add(new User(3, "User3", "user3@yahoo.com", "+1234563", "", RolesEnum.CLIENT));
        userList.add(new User(4, "User4", "user4@yahoo.com", "+1234564", "", RolesEnum.CLIENT));
        userList.add(new User(5, "User5", "user5@yahoo.com", "+1234565", "", RolesEnum.CLIENT));

        System.out.println("Выполняем логику при создании объекта "+this.getClass().getName());
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public User getUserById(Long id) {
        return userList.stream()
                .filter(user -> user.getUserId()==id)
                .findFirst()
                .orElse(null);
    }

    // Экранирование кириллицы для url - https://planetcalc.ru/683/
    public User getUserByName(String name) {
        return userList.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public boolean createUser(User newUser) { //insert
        return userList.add(newUser);
    }

    public User updateUser(User updUser) { //update
        User result = userList.stream()
                .filter(user -> user.getUserId() == updUser.getUserId())
                .findFirst()
                .orElse(null);
        if(result!=null) {
            result.setName(updUser.getName());
            result.setEmail(updUser.getEmail());
            result.setPhoneNumber(updUser.getPhoneNumber());        }
        return result;
    }

    public void deleteUser(Long id) { //delete
        Iterator<User> it = userList.iterator();
        while (it.hasNext()) {
            User current = it.next();
            if(current.getUserId()==id) {
                it.remove();
            }
        }
    }

    public void destroy() {
        userList.clear();
        System.out.println("Run code after finishing work with the object: "
                + this.getClass().getName());
    }

}
