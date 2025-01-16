package de.telran.onlineshop.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Instance of Product")
public class ProductDto {

    @Schema(description = "Unique Identifier of a Product", example = "2", accessMode = Schema.AccessMode.READ_ONLY)
    @PositiveOrZero(message = "Invalid ProductId: must be >= 0")
    private Long productId;

    @Schema(description = "Name of a Product", example = "ProductName")
    @NotNull(message = "Invalid Product Name: NULL")
    @NotEmpty(message = "Invalid Product Name: empty name")
    @Size(min = 2, max = 30, message = "Invalid Product Name: must be of 2-30 characters")
    private String name;

    @Schema(description = "Description of a Product", example = "Description")
    @NotBlank(message = "Invalid Product Description: description should NOT be blank")
    private String description;

    @Schema(description = "Price of a Product", example = "100.00")
    @PositiveOrZero(message = "Invalid Product Price: must be >= 0")
    private Double price;

    @Schema(description = "URL of an image of a Product", example = "www.publicstore.de/id=1")
    @NotNull(message = "Invalid Product imageUrl: NULL")
    private String imageUrl;

    @Schema(description = "Discount Price of a Product", example = "99.00")
    @PositiveOrZero(message = "Invalid Product Discount Price: must be >= 0")
    private Double discountPrice;

    @Schema(description = "Time, when a Product created", example = "yyyy-mm-dd--hh-mm-ss")
    @PastOrPresent(message = "Invalid Product CreatedAt time: must be in PAST or PRESENT")
    private Timestamp createdAt;

    @Schema(description = "Time, when a Product updated", example = "yyyy-mm-dd--hh-mm-ss")
    @FutureOrPresent(message = "Invalid Product UpdatedAt time: must be in FUTURE or PRESENT")
    private Timestamp updatedAt;

    @Schema(description = "Category of a Product", example = "CategoryObject")
    @NotNull(message = "Invalid Product category: NULL")
    private CategoryDto category;

    @Schema(description = "List of Cart's Items for a Product", example = "{CartItem1, CartItem1}")
    @NotNull(message = "Invalid Product cartItems list: NULL")
    private Set<CartItemDto> cartItems = new HashSet<>();

    @Schema(description = "List of Order's Items for a Product", example = "{OrderItem1, OrderItem2}")
    @NotNull(message = "Invalid Product orderItems list: NULL")
    private Set<OrderItemDto> orderItems = new HashSet<>();

    @Schema(description = "List of Favorites for a Product", example = "{Favorite1, Favorite2}")
    @NotNull(message = "Invalid Product favorites list: NULL")
    private Set<FavoriteDto> favorites = new HashSet<>();

}
