package de.telran.onlineshop.service;

import de.telran.onlineshop.dto.UserDto;
import de.telran.onlineshop.entity.CartEntity;
import de.telran.onlineshop.entity.UsersEntity;
import de.telran.onlineshop.entity.enums.Role;
import de.telran.onlineshop.repository.CartRepository;
import de.telran.onlineshop.repository.UsersRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;
    private final CartRepository cartRepository;
    private List<UserDto> userDtoList;

    @PostConstruct
    void init() {
        userDtoList = new ArrayList<>();
/*
        userDtoList.add(new UserDto(1, "User1", "user1@yahoo.com", "+1234561", "111", RolesEnum.ADMINISTRATOR));
        userDtoList.add(new UserDto(2, "User2", "user2@yahoo.com", "+1234562", "222", RolesEnum.CLIENT));
        userDtoList.add(new UserDto(3, "User3", "user3@yahoo.com", "+1234563", "333", RolesEnum.CLIENT));
        userDtoList.add(new UserDto(4, "User4", "user4@yahoo.com", "+1234564", "444", RolesEnum.CLIENT));
        userDtoList.add(new UserDto(5, "User5", "user5@yahoo.com", "+1234565", "555", RolesEnum.CLIENT));
*/
        CartEntity cart1 = new CartEntity();
        cart1 = cartRepository.save(cart1);
        UsersEntity user1 = new UsersEntity(null, "Вася Пупкин", "a@test.us", "1111111", "12345",  Role.CLIENT, null, null, cart1);
        usersRepository.save(user1);

        CartEntity cart2 = new CartEntity();
        cart2 = cartRepository.save(cart2);
        UsersEntity user2 = new UsersEntity(null, "Дуня Семенова", "a@test.us", "1111111", "12345",  Role.ADMIN, null, null, cart2);
        usersRepository.save(user2);


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
