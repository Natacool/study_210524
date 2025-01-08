package de.telran.onlineshop.service;

import de.telran.onlineshop.configure.MapperUtil;
import de.telran.onlineshop.dto.UserDto;
import de.telran.onlineshop.entity.CartEntity;
import de.telran.onlineshop.entity.UsersEntity;
import de.telran.onlineshop.entity.enums.Role;
import de.telran.onlineshop.mapper.Mappers;
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
    private final Mappers mappers;


    @PostConstruct
    void init() {
/*
        userDtoList.add(new UserDto(1, "User1", "user1@yahoo.com", "+1234561", "111", RolesEnum.ADMINISTRATOR));
        userDtoList.add(new UserDto(2, "User2", "user2@yahoo.com", "+1234562", "222", RolesEnum.CLIENT));
        userDtoList.add(new UserDto(3, "User3", "user3@yahoo.com", "+1234563", "333", RolesEnum.CLIENT));
        userDtoList.add(new UserDto(4, "User4", "user4@yahoo.com", "+1234564", "444", RolesEnum.CLIENT));
        userDtoList.add(new UserDto(5, "User5", "user5@yahoo.com", "+1234565", "555", RolesEnum.CLIENT));
*/
        CartEntity cart1 = new CartEntity();
        cart1 = cartRepository.save(cart1);
        UsersEntity user1 = new UsersEntity(null, "Вася Пупкин", "a@test.us", "1111111", "12345",  Role.CLIENT, cart1, null, null);
        usersRepository.save(user1);

        CartEntity cart2 = new CartEntity();
        cart2 = cartRepository.save(cart2);
        UsersEntity user2 = new UsersEntity(null, "Дуня Семенова", "a@test.us", "1111111", "12345",  Role.ADMIN, cart2, null, null);
        usersRepository.save(user2);


        System.out.println("Выполняем логику при создании объекта "+this.getClass().getName());
    }

    public List<UserDto> getAllUsers() {
        List<UsersEntity> usersEntities = usersRepository.findAll();
        List<UserDto> userDtoList = MapperUtil.convertList(usersEntities, mappers::convertToUserDto);
        return userDtoList;
    }

    public UserDto getUserById(Long id) {
        UsersEntity usersEntity = usersRepository.findById(id).orElse(new UsersEntity());
        UserDto userDto = mappers.convertToUserDto(usersEntity);
        return userDto;
    }

    public UserDto getUserByName(String name) {
        UsersEntity usersEntity = usersRepository.findByNameNative(name);
        UserDto userDto = mappers.convertToUserDto(usersEntity);
        return userDto;
    }

    public boolean createUser(UserDto newUser) { //insert
        UsersEntity usersEntity = mappers.convertToUserEntity(newUser);
        usersEntity.setUserId(null);
        UsersEntity savedUsersEntity = usersRepository.save(usersEntity);
        UserDto userDto = mappers.convertToUserDto(savedUsersEntity);
        return userDto != null;
    }

    public UserDto insertUser(UserDto newUser) { //insert
        UsersEntity usersEntity = mappers.convertToUserEntity(newUser);
        usersEntity.setUserId(null);
        UsersEntity savedUsersEntity = usersRepository.save(usersEntity);
        return mappers.convertToUserDto(savedUsersEntity);
    }

    public UserDto updateUser(UserDto updUser) { //update
        UsersEntity usersEntity = mappers.convertToUserEntity(updUser); // из Dto в Entity
        UsersEntity returnUserEntity = usersRepository.save(usersEntity); // сохранили в БД
        return mappers.convertToUserDto(returnUserEntity); //из Entity  в Dto
    }

    public void deleteUser(Long id) { //delete
        UsersEntity usersEntity = usersRepository.findById(id).orElse(null);
        if (usersEntity != null) {
            usersRepository.delete(usersEntity);
        } else {
            throw new NullPointerException("Not Found UsersEntity");
        }
    }

    public void deleteUserById(Long id) { //delete
        UsersEntity usersEntity = usersRepository.findById(id).orElse(null);
        if (usersEntity != null) {
            usersRepository.delete(usersEntity);
        } else {
            throw new NullPointerException("Not Found UsersEntity");
        }
    }
    public void destroy() {
        System.out.println("Run code after finishing work with the object: "
                + this.getClass().getName());
    }

}
