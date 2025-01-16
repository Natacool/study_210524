package de.telran.onlineshop.controller;

import de.telran.onlineshop.dto.OrderDto;
import de.telran.onlineshop.dto.OrderItemDto;
import de.telran.onlineshop.service.CartItemsService;
import de.telran.onlineshop.service.OrderItemsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/order_items")
@RequiredArgsConstructor
public class OrderItemsController implements OrderItemsControllerInterface {
    private final OrderItemsService orderItemsService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping  //select
    public List<OrderItemDto> getAllOrders() {
        return orderItemsService.getAllOrderItems();
    }

    @GetMapping(value = "/find/{id}")
    public OrderItemDto getOrderItemById(@PathVariable Long id) { ///users/find/3
        return orderItemsService.getOrderItemById(id);
    }

    @PostMapping //Jackson
    public boolean createOrderItem(@RequestBody @Valid OrderItemDto newOrderItem) { //insert
        return orderItemsService.createOrderItem(newOrderItem);
    }

    @PutMapping
    public OrderItemDto updateOrderItem(@RequestBody @Valid OrderItemDto updOrderItem) { //update
        return orderItemsService.updateOrderItem(updOrderItem);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteOrderItem(@PathVariable Long id) { //delete
        orderItemsService.deleteOrderItem(id);
    }


    // For testing purpose
    @GetMapping(value = "/test")
    String orderItemsGet(){
        return "Привет, я контроллер - OrderItemsController, " + this.toString();
    }
}
