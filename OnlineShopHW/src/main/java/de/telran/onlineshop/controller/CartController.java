package de.telran.onlineshop.controller;

import de.telran.onlineshop.dto.CartDto;
import de.telran.onlineshop.dto.OrderDto;
import de.telran.onlineshop.service.CartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cart")
@RequiredArgsConstructor
public class CartController implements CartControllerInterface {
    private final CartService cartService;
/*
    //@Autowired// - инъекция через конструктор (рекомендуемая !!!), авто аннотирование с версии 3.0
    public CartsController(CartsService cartsService) {
        this.cartsService = cartsService;
    }

    // @Autowired - инъекция через сеттер (обязательно использовать аннотацию)
    public void setCategoryService(CartsService cartsService) {
        this.cartsService = cartsService;
    }
*/

    @ResponseStatus(HttpStatus.OK)
    @GetMapping  //select
    public List<CartDto> getAllCarts() {
        return cartService.getAllCarts();
    }

    @GetMapping(value = "/find/{id}")
    public CartDto getCartById(@PathVariable Long id) { ///users/find/3
        return cartService.getCartById(id);
    }

    @PostMapping //Jackson
    public boolean createCart(@RequestBody @Valid CartDto newCart) { //insert
        return cartService.createCart(newCart);
    }

    @PutMapping
    public CartDto updateCart(@RequestBody @Valid CartDto updCart) { //update
        return cartService.updateCart(updCart);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCart(@PathVariable Long id) { //delete
        cartService.deleteCart(id);
    }

    // For testing purpose
    @GetMapping(value = "/test")
    String cartGet(){
        return "Привет, я контроллер - CartController, " + this.toString();
    }

}
