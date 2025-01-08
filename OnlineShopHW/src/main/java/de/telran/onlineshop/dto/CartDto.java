package de.telran.onlineshop.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class CartDto {
    @PositiveOrZero(message = "Invalid CartId: must be >= 0")
    private Long cartId;

    @NotNull(message = "Invalid Cart cartItems list: NULL")
    private Set<CartItemDto> cartItems = new HashSet<>();

    //@NotNull(message = "Invalid Order user: NULL")
    //private UserDto user;
}
