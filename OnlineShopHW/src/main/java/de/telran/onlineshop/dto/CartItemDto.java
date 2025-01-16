package de.telran.onlineshop.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Instance of Cart Item")
public class CartItemDto {

    @Schema(description = "Unique Identifier of a Cart's Item", example = "2", accessMode = Schema.AccessMode.READ_ONLY)
    @PositiveOrZero(message = "Invalid CartItemId: must be >= 0")
    private Long cartItemId;

    @Schema(description = "Cart for Cart's Item", example = "CartObject")
    @NotNull(message = "Invalid CartItem cart: NULL")
    private CartDto cart;

    @Schema(description = "Product for Cart's Item", example = "ProductObject")
    @NotNull(message = "Invalid CartItem product: NULL")
    private ProductDto product;

    @Schema(description = "Amount of Cart's Items", example = "9")
    @Positive(message = "Invalid CartItem Quantity: must be > 0")
    private Integer quantity;
}
