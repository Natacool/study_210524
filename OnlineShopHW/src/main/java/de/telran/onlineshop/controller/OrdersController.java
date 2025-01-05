package de.telran.onlineshop.controller;

import de.telran.onlineshop.dto.OrderDto;
import de.telran.onlineshop.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
@RequiredArgsConstructor
public class OrdersController {
    private final OrdersService orderService;
    @GetMapping
    String ordersGet(){
        return "Привет, я контроллер - OrdersController, " + this.toString();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping  //select
    public List<OrderDto> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping(value = "/find/{id}")
    public OrderDto getProductById(@PathVariable Long id) { ///users/find/3
        return orderService.getOrderById(id);
    }

    @PostMapping //Jackson
    public boolean createOrder(@RequestBody OrderDto newOrder) { //insert
        return orderService.createOrder(newOrder);
    }

    @PutMapping
    public OrderDto updateOrder(@RequestBody OrderDto updOrder) { //update
        return orderService.updateOrder(updOrder);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteOrder(@PathVariable Long id) { //delete
        orderService.deleteOrder(id);
    }

}
