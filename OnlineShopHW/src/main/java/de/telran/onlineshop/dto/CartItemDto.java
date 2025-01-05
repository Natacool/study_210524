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
    private Long cartItemId;
    //private CartDto cartId;
    private Long cartId;
    //private ProductDto productId;
    private Long productId;
    private Integer quantity;
}
