package de.telran.onlineshop.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
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
public class OrderItemDto {
    @PositiveOrZero(message = "Invalid OrderItemId: must be >= 0")
    private Long orderItemId;

    @NotNull(message = "Invalid OrderItem order: NULL")
    private OrderDto order;

    @NotNull(message = "Invalid OrderItem product: NULL")
    private ProductDto product;

    @Positive(message = "Invalid OrderItem Quantity: must be > 0")
    private Integer quantity;

    @PositiveOrZero(message = "Invalid OrderItem Price At Purchase: must be >= 0")
    private Double priceAtPurchase;
}
