package de.telran.onlineshop.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class OrderItemDto {
    private Long orderItemId;
    //private OrderDto orderId;
    private Long orderId;
    //private ProductDto productId;
    private Long productId;
    private Integer quantity;
    private Double priceAtPurchase;

}
