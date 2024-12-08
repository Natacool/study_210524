package de.telran.onlineshop.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class CartItemDto {
    private long cartItemId;
    private long cartId;
    private long productId;
    private int quantity;


}
