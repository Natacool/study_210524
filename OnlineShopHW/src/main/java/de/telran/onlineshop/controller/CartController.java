package de.telran.onlineshop.controller;

import de.telran.onlineshop.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cart")
@RequiredArgsConstructor
public class CartController {
    private CartService cartService;
/*
    //@Autowired// - иньекция через конструктор (рекомендуемая !!!), авто аннотирование с версии 3.0
    public CartsController(CartsService cartsService) {
        this.cartsService = cartsService;
    }

    // @Autowired - иньекция через сеттер (обязательно использовать аннотацию)
    public void setCategoryService(CartsService cartsService) {
        this.cartsService = cartsService;
    }
*/
    @GetMapping
    String cartGet(){
        return "Привет, я контроллер - CartController, " + this.toString();
    }





}
