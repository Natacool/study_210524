package de.telran.onlineshop.controller;

import de.telran.onlineshop.dto.CartDto;
import io.swagger.v3.oas.annotations.Hidden;

import java.util.List;

public interface CartControllerInterface {

    @Hidden
    public List<CartDto> getAllCarts();

    @Hidden
    public CartDto getCartById(Long id);

    @Hidden
    public boolean createCart(CartDto newCart);

    @Hidden
    public CartDto updateCart(CartDto updCart);

    @Hidden
    public void deleteCart(Long id);

}
