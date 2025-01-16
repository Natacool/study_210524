package de.telran.onlineshop.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Instance of Order's Item")
public class OrderItemDto {

    @Schema(description = "Unique Identifier of an Order's Item ", example = "2", accessMode = Schema.AccessMode.READ_ONLY)
    @PositiveOrZero(message = "Invalid OrderItemId: must be >= 0")
    private Long orderItemId;

    @Schema(description = "Order for a Order's Item", example = "OrderObject")
    @NotNull(message = "Invalid OrderItem order: NULL")
    private OrderDto order;

    @Schema(description = "Product for a Order's Item", example = "ProductObject")
    @NotNull(message = "Invalid OrderItem product: NULL")
    private ProductDto product;

    @Schema(description = "Amount of a Order's Items", example = "101.00")
    @Positive(message = "Invalid OrderItem Quantity: must be > 0")
    private Integer quantity;

    @Schema(description = "Price at purchase of a Order's Item", example = "101.00")
    @PositiveOrZero(message = "Invalid OrderItem Price At Purchase: must be >= 0")
    private Double priceAtPurchase;
}
