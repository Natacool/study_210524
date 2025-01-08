package de.telran.onlineshop.controller;

import de.telran.onlineshop.dto.CartDto;
import de.telran.onlineshop.dto.CartItemDto;
import de.telran.onlineshop.dto.OrderDto;
import de.telran.onlineshop.service.CartItemsService;
import de.telran.onlineshop.service.CartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cart_items")
@RequiredArgsConstructor
public class CartItemsController {
    private final CartItemsService cartItemService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping  //select
    public List<CartItemDto> getAllCartItems() {
        return cartItemService.getAllCartItems();
    }

    @GetMapping(value = "/find/{id}")
    public CartItemDto getCartItemById(@PathVariable Long id) { ///users/find/3
        return cartItemService.getCartItemById(id);
    }

    @PostMapping //Jackson
    public boolean createCartItem(@RequestBody @Valid CartItemDto newCartItem) { //insert
        return cartItemService.createCartItem(newCartItem);
    }

    @PutMapping
    public CartItemDto updateCartItem(@RequestBody @Valid CartItemDto updCartItem) { //update
        return cartItemService.updateCartItem(updCartItem);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCartItem(@PathVariable Long id) { //delete
        cartItemService.deleteCartItem(id);
    }


    // For testing purpose
    @GetMapping(value = "/test")
    String cartItemsGet(){
        return "Привет, я контроллер - CartItemsController, " + this.toString();
    }
}
