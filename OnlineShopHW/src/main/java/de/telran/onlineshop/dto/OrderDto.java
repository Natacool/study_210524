package de.telran.onlineshop.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import de.telran.onlineshop.entity.enums.Status;
import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class OrderDto {
    @PositiveOrZero(message = "Invalid OrderId: must be >= 0")
    private Long orderId;

    @NotNull(message = "Invalid Order user: NULL")
    private UserDto user;

    @PastOrPresent(message = "Invalid Order CreatedAt time: must be in PAST or PRESENT")
    private Timestamp createdAt;

    @NotNull(message = "Invalid Order DeliveryAddress: NULL")
    @NotEmpty(message = "Invalid Order DeliveryAddress: empty delivery address")
    @NotBlank(message = "Invalid Order DeliveryAddress: must NOT empty")
    private String deliveryAddress;

    @NotBlank(message = "Invalid Order Phone Number: empty number")
    @Pattern(regexp = "^\\d{12}$", message = "Invalid Order Phone")
    private String contactPhone;

    @NotBlank(message = "Invalid Order Delivery Method: empty delivery method")
    private String deliveryMethod;

    @NotNull(message = "Invalid Order status: NULL")
    private Status status;

    @FutureOrPresent(message = "Invalid Order UpdatedAt time: must be in FUTURE or PRESENT")
    private Timestamp updatedAt;

    @NotNull(message = "Invalid Order orderItems list: NULL")
    private Set<OrderItemDto> orderItems = new HashSet<>();
}
