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
    private long favoriteId;
    private long userId;
    private long productId;
}
