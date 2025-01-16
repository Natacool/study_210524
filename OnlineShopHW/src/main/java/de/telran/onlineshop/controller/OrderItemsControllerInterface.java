package de.telran.onlineshop.controller;

import de.telran.onlineshop.dto.OrderItemDto;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

public interface OrderItemsControllerInterface {

    @Operation(
            summary = "All Items in the Order",
            description = "This method gets all Items from a user's Order"
    )
    public List<OrderItemDto> getAllOrders();

    @Operation(
            summary = "Search by Id",
            description = "This method searches an Item in the Order by Id"
    )
    public OrderItemDto getOrderItemById(Long id);

    @Operation(
            summary = "Create a new Order's Item",
            description = "This method creates a new Item in the Order"
    )
    public boolean createOrderItem(OrderItemDto newOrderItem);

    @Operation(
            summary = "Update an Order's Item",
            description = "This method updates an existing Item in the Order"
    )
    public OrderItemDto updateOrderItem(OrderItemDto updOrderItem);

    @Operation(
            summary = "Delete an Order's Item",
            description = "This method deletes an existing Order's Item by Id"
    )
    public void deleteOrderItem(Long id);

}
