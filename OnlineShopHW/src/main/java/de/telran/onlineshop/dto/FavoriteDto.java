package de.telran.onlineshop.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class FavoriteDto {
    private Long favoriteId;
    //private UserDto user;
    private Long userId;
    //private ProductDto product;
    private Long productId;
}
