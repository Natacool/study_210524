package de.telran.onlineshop.controller;

import de.telran.onlineshop.service.CartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cart")
public class CartController {
    private CartService cartService;

    //@Autowired// - иньекция через конструктор (рекомендуемая !!!), авто аннотирование с версии 3.0
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // @Autowired - иньекция через сеттер (обязательно использовать аннотацию)
    public void setCategoryService(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    String cartGet(){
        return "Привет, я контроллер - CartController, " + this.toString();
    }
}
