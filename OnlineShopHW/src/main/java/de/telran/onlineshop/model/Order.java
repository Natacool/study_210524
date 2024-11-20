package de.telran.onlineshop.model;

import java.time.LocalDateTime;

public class Order {
    private long orderId;
    private long userId;
    private LocalDateTime createdAt;
    private String deliveryAddress;
    private String contactPhone;
    private String deliveryMethod;
    private OrderStatusEnum status;
    private LocalDateTime updatedAt;

}
