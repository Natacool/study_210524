package de.telran.onlineshop.controller;

import de.telran.onlineshop.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UsersControllerInterface {

    @Operation(
            summary = "All Users",
            description = "This method gets all Users"
    )
    public ResponseEntity<List<UserDto>> getAllUsers();

    @Operation(
            summary = "Search by Id",
            description = "This method searches a User by Id"
    )
    public ResponseEntity<UserDto> getUserById(Long id);

    @Operation(
            summary = "Search by Name",
            description = "This method searches a User by Name"
    )
    public ResponseEntity<UserDto> getUserByName(String name);

    @Operation(
            summary = "Create a new User",
            description = "This method creates a new User and return boolean"
    )
    public ResponseEntity<Boolean> createUser(UserDto newUser);

    @Operation(
            summary = "Create a new User",
            description = "This method creates a new User and return the new User"
    )
    public ResponseEntity<UserDto> insertUser(UserDto newUser);

    @Operation(
            summary = "Update a User",
            description = "This method updates an existing User"
    )
    public ResponseEntity<UserDto> updateUser(UserDto updUser);

    @Operation(
            summary = "Delete an existing User",
            description = "This method deletes an existing User by Id"
    )
    public ResponseEntity<UserDto> deleteUser(Long id);
}
