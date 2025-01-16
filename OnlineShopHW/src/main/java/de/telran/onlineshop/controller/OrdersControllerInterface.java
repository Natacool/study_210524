package de.telran.onlineshop.controller;

import de.telran.onlineshop.dto.OrderDto;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

public interface OrdersControllerInterface {

    @Operation(
            summary = "All Orders",
            description = "This method gets all Orders"
    )
    public List<OrderDto> getAllOrders();

    @Operation(
            summary = "Search by Id",
            description = "This method searches an Order by Id"
    )
    public OrderDto getProductById(Long id);

    @Operation(
            summary = "Create a new Order",
            description = "This method creates a new Order"
    )
    public boolean createOrder(OrderDto newOrder);

    @Operation(
            summary = "Update an Order",
            description = "This method updates an existing Order"
    )
    public OrderDto updateOrder(OrderDto updOrder);

    @Operation(
            summary = "Delete an Order",
            description = "This method deletes an existing Order by Id"
    )
    public void deleteOrder(Long id);

}
