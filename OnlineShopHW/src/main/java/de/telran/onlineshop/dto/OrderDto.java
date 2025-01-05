package de.telran.onlineshop.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import de.telran.onlineshop.entity.enums.Status;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class OrderDto {
    private Long orderId;
    //private UserDto userId;
    private Long userId;
    private Timestamp createdAt;
    private String deliveryAddress;
    private String contactPhone;
    private String deliveryMethod;
//    private OrderStatusEnum status;
    private Status status;
//    private LocalDateTime updatedAt;
    private Timestamp updatedAt;

}
