package de.telran.onlineshop.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FavoriteDto {
    @PositiveOrZero(message = "Invalid FavoriteId: must be >= 0")
    private Long favoriteId;

    @NotNull(message = "Invalid Favorite user: NULL")
    private UserDto user;

    @NotNull(message = "Invalid Favorite product: NULL")
    private ProductDto product;
}
