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
    private long orderItemId;
    private long orderId;
    private long productId;
    private int quantity;
    private float priceAtPurchase;

}
