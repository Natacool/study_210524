package de.telran.onlineshop.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL) //если равно null - скрыть в выводе
public class UserDto {
    private Long userId;
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL) //если равно null - скрыть в выводе
    private String email;
    private String phoneNumber;
    private String passwordHash;
    RolesEnum role;

    private Set<FavoriteDto> favorites = new HashSet<>();
    //private CartDto cart;
    private Long cart;

    public UserDto() {
    }

    public UserDto(long userId, String name, String email,
                   String phoneNumber, String passwordHash,
                   RolesEnum role) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.passwordHash = passwordHash;
        this.role = role;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public RolesEnum getRole() {
        return role;
    }

    public void setRole(RolesEnum role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDto user)) return false;
        return userId == user.userId
                && Objects.equals(getName(), user.getName())
                && Objects.equals(getEmail(), user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, getName(), getEmail());
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", role=" + role +
                '}';
    }
}
