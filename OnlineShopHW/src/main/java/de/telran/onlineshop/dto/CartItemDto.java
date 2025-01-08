package de.telran.onlineshop.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class CartItemDto {
    @PositiveOrZero(message = "Invalid CartItemId: must be >= 0")
    private Long cartItemId;

    @NotNull(message = "Invalid CartItem cart: NULL")
    private CartDto cart;

    @NotNull(message = "Invalid CartItem product: NULL")
    private ProductDto product;

    @Positive(message = "Invalid CartItem Quantity: must be > 0")
    private Integer quantity;
}
