package de.telran.onlineshop.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Instance of Cart")
public class CartDto {

    @Schema(description = "Unique Identifier of a Cart", example = "2", accessMode = Schema.AccessMode.READ_ONLY)
    @PositiveOrZero(message = "Invalid CartId: must be >= 0")
    private Long cartId;

    @Schema(description = "List of Cart's Items in a Cart", example = "{CartItem1, CartItem2}")
    @NotNull(message = "Invalid Cart cartItems list: NULL")
    private Set<CartItemDto> cartItems = new HashSet<>();

    @Schema(description = "User for Cart", example = "UserObject")
    @NotNull(message = "Invalid Order user: NULL")
    private UserDto user;
}
