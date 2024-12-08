package de.telran.onlineshop.dto;

import java.time.LocalDateTime;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class OrderDto {
    private long orderId;
    private long userId;
    private LocalDateTime createdAt;
    private String deliveryAddress;
    private String contactPhone;
    private String deliveryMethod;
    private OrderStatusEnum status;
    private LocalDateTime updatedAt;

}
