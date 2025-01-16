package de.telran.onlineshop.controller;

import de.telran.onlineshop.dto.CartItemDto;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

public interface CartItemsControllerInterface {

    @Operation(
            summary = "All Items in the Cart",
            description = "This method gets all Items from a user's Cart"
    )
    public List<CartItemDto> getAllCartItems();

    @Operation(
            summary = "Search by Id",
            description = "This method searches am Item in the Cart by Id"
    )
    public CartItemDto getCartItemById(Long id);

    @Operation(
            summary = "Create a new Cart's Item",
            description = "This method creates a new Item in the Cart"
    )
    public boolean createCartItem(CartItemDto newCartItem);

    @Operation(
            summary = "Update a Cart's Item",
            description = "This method updates an existing Item in the Cart"
    )
    public CartItemDto updateCartItem(CartItemDto updCartItem);

    @Operation(
            summary = "Delete a Cart's Item",
            description = "This method deletes an existing Cart's Item by Id"
    )
    public void deleteCartItem(Long id);

}
