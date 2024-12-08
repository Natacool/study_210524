package de.telran.onlineshop.service;

import de.telran.onlineshop.dto.RolesEnum;
import de.telran.onlineshop.dto.UserDto;
import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UsersService {
    private List<UserDto> userDtoList;

    @PostConstruct
    void init() {
        userDtoList = new ArrayList<>();
        userDtoList.add(new UserDto(1, "User1", "user1@yahoo.com", "+1234561", "", RolesEnum.ADMINISTRATOR));
        userDtoList.add(new UserDto(2, "User2", "user2@yahoo.com", "+1234562", "", RolesEnum.CLIENT));
        userDtoList.add(new UserDto(3, "User3", "user3@yahoo.com", "+1234563", "", RolesEnum.CLIENT));
        userDtoList.add(new UserDto(4, "User4", "user4@yahoo.com", "+1234564", "", RolesEnum.CLIENT));
        userDtoList.add(new UserDto(5, "User5", "user5@yahoo.com", "+1234565", "", RolesEnum.CLIENT));

        System.out.println("Выполняем логику при создании объекта "+this.getClass().getName());
    }

    public List<UserDto> getAllUsers() {
        return userDtoList;
    }

    public UserDto getUserById(Long id) {
        return userDtoList.stream()
                .filter(user -> user.getUserId()==id)
                .findFirst()
                .orElse(null);
    }

    // Экранирование кириллицы для url - https://planetcalc.ru/683/
    public UserDto getUserByName(String name) {
        return userDtoList.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public boolean createUser(UserDto newUser) { //insert
        return userDtoList.add(newUser);
    }

    public UserDto updateUser(UserDto updUser) { //update
        UserDto result = userDtoList.stream()
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
        Iterator<UserDto> it = userDtoList.iterator();
        while (it.hasNext()) {
            UserDto current = it.next();
            if(current.getUserId()==id) {
                it.remove();
            }
        }
    }

    public void destroy() {
        userDtoList.clear();
        System.out.println("Run code after finishing work with the object: "
                + this.getClass().getName());
    }

}
