package de.telran.onlineshop.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import de.telran.onlineshop.entity.enums.Role;
import jakarta.validation.constraints.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL) //если равно null - скрыть в выводе
public class UserDto {
    @PositiveOrZero(message = "Invalid UserId: must be >= 0")
    private Long userId;

    @NotNull(message = "Invalid User Name: NULL")
    @NotEmpty(message = "Invalid User Name: empty name")
    @Size(min = 2, max = 30, message = "Invalid User Name: must be of 2-30 characters")
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL) //если равно null - скрыть в выводе
    @Email(message = "Invalid email")
    private String email;

    @NotBlank(message = "Invalid phone number: empty number")
    @Pattern(regexp = "^\\d{12}$", message = "Invalid phone number")
    private String phoneNumber;

//    @NotNull
//    private Role role;

    @NotNull(message = "Invalid User passwordHash: NULL")
    @NotEmpty(message = "Invalid User passwordHash: EMPTY")
    private String passwordHash;

    @NotNull(message = "Invalid User cart: NULL")
    private CartDto cart;

    @NotNull(message = "Invalid User favorites list: NULL")
    private Set<FavoriteDto> favorites = new HashSet<>();

    @NotNull(message = "Invalid User orders list: NULL")
    private Set<OrderDto> orders = new HashSet<>();

    public UserDto(Long userId, String name, String email, String phoneNumber, String passwordHash) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.passwordHash = passwordHash;
    }

    public UserDto() {
    }

    public CartDto getCart() {
        return cart;
    }

    public void setCart(CartDto cart) {
        this.cart = cart;
    }

    public Set<FavoriteDto> getFavorites() {
        return favorites;
    }

    public void setFavorites(Set<FavoriteDto> favorites) {
        this.favorites = favorites;
    }

    public Set<OrderDto> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderDto> orders) {
        this.orders = orders;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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
                '}';
    }
}
