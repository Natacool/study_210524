package de.telran.onlineshop.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import de.telran.onlineshop.entity.enums.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
@Schema(description = "Instance of Order")
public class OrderDto {

    @Schema(description = "Unique Identifier of an Order", example = "2", accessMode = Schema.AccessMode.READ_ONLY)
    @PositiveOrZero(message = "Invalid OrderId: must be >= 0")
    private Long orderId;

    @Schema(description = "User, who creates an Order", example = "UserObject")
    @NotNull(message = "Invalid Order user: NULL")
    private UserDto user;

    @Schema(description = "Time, when an Order creates", example = "yyyy-mm-dd--hh-mm-ss")
    @PastOrPresent(message = "Invalid Order CreatedAt time: must be in PAST or PRESENT")
    private Timestamp createdAt;

    @Schema(description = "Delivery Address for an Order", example = "Country, City, PostalIndex, HouseNumber, Street[,  FlatNumber]")
    @NotNull(message = "Invalid Order DeliveryAddress: NULL")
    @NotEmpty(message = "Invalid Order DeliveryAddress: empty delivery address")
    @NotBlank(message = "Invalid Order DeliveryAddress: must NOT empty")
    private String deliveryAddress;

    @Schema(description = "Contact Phone for Order delivery", example = "+49123456789")
    @NotBlank(message = "Invalid Order Phone Number: empty number")
    @Pattern(regexp = "^\\d{12}$", message = "Invalid Order Phone")
    private String contactPhone;

    @Schema(description = "Delivery Method of an Order", example = "DHL")
    @NotBlank(message = "Invalid Order Delivery Method: empty delivery method")
    private String deliveryMethod;

    @Schema(description = "Status of an Order", example = "Создан")
    @NotNull(message = "Invalid Order status: NULL")
    private Status status;

    @Schema(description = "Time, when an Order updated", example = "yyyy-mm-dd--hh-mm-ss")
    @FutureOrPresent(message = "Invalid Order UpdatedAt time: must be in FUTURE or PRESENT")
    private Timestamp updatedAt;

    @Schema(description = "List of Order's Items for an Order", example = "{OrderItem1, OrderItem2}")
    @NotNull(message = "Invalid Order orderItems list: NULL")
    private Set<OrderItemDto> orderItems = new HashSet<>();
}
