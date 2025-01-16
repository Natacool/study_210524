package de.telran.onlineshop.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "Instance of Favorite")
public class FavoriteDto {

    @Schema(description = "Unique Identifier of a Favorite", example = "2", accessMode = Schema.AccessMode.READ_ONLY)
    @PositiveOrZero(message = "Invalid FavoriteId: must be >= 0")
    private Long favoriteId;

    @Schema(description = "User for Favorite", example = "UserObject")
    @NotNull(message = "Invalid Favorite user: NULL")
    private UserDto user;

    @Schema(description = "Product for Favorite", example = "ProductObject")
    @NotNull(message = "Invalid Favorite product: NULL")
    private ProductDto product;
}
