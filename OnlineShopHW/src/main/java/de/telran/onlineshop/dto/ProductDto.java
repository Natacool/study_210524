package de.telran.onlineshop.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class ProductDto {
    @PositiveOrZero(message = "Invalid ProductId: must be >= 0")
    private Long productId;

    @NotNull(message = "Invalid Product Name: NULL")
    @NotEmpty(message = "Invalid Product Name: empty name")
    @Size(min = 2, max = 30, message = "Invalid Product Name: must be of 2-30 characters")
    private String name;

    @NotBlank(message = "Invalid Product Description: description should NOT be blank")
    private String description;

    @PositiveOrZero(message = "Invalid Product Price: must be >= 0")
    private Double price;

    @NotNull(message = "Invalid Product imageUrl: NULL")
    private String imageUrl;

    @PositiveOrZero(message = "Invalid Product Discount Price: must be >= 0")
    private Double discountPrice;

    @PastOrPresent(message = "Invalid Product CreatedAt time: must be in PAST or PRESENT")
    private Timestamp createdAt;

    @FutureOrPresent(message = "Invalid Product UpdatedAt time: must be in FUTURE or PRESENT")
    private Timestamp updatedAt;

    @NotNull(message = "Invalid Product category: NULL")
    private CategoryDto category;

    @NotNull(message = "Invalid Product cartItems list: NULL")
    private Set<CartItemDto> cartItems = new HashSet<>();

    @NotNull(message = "Invalid Product orderItems list: NULL")
    private Set<OrderItemDto> orderItems = new HashSet<>();

    @NotNull(message = "Invalid Product favorites list: NULL")
    private Set<FavoriteDto> favorites = new HashSet<>();

}
