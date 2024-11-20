package de.telran.onlineshop.controller;

import de.telran.onlineshop.service.CartsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cart")
public class CartsController {
    private CartsService cartsService;

    //@Autowired// - иньекция через конструктор (рекомендуемая !!!), авто аннотирование с версии 3.0
    public CartsController(CartsService cartsService) {
        this.cartsService = cartsService;
    }

    // @Autowired - иньекция через сеттер (обязательно использовать аннотацию)
    public void setCategoryService(CartsService cartsService) {
        this.cartsService = cartsService;
    }

    @GetMapping
    String cartGet(){
        return "Привет, я контроллер - CartController, " + this.toString();
    }
}
