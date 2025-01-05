package de.telran.onlineshop.service;

import de.telran.onlineshop.dto.FavoriteDto;
import de.telran.onlineshop.dto.OrderDto;
import de.telran.onlineshop.dto.OrderItemDto;
import de.telran.onlineshop.dto.ProductDto;
import de.telran.onlineshop.entity.*;
import de.telran.onlineshop.repository.OrderItemsRepository;
import de.telran.onlineshop.repository.OrdersRepository;
import de.telran.onlineshop.repository.ProductsRepository;
import de.telran.onlineshop.repository.UsersRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class OrderItemsService {
    private final OrderItemsRepository orderItemsRepository;
    private final OrdersRepository ordersRepository;
    private final ProductsRepository productsRepository;
    private List<OrderItemDto> orderItemDtoList;
    @PostConstruct
    void init() {
        orderItemDtoList = new ArrayList<>();

        OrdersEntity order1 = ordersRepository.findById(1L).orElse(null);
        ProductsEntity product1 = productsRepository.findById(2L).orElse(null);
        OrderItemsEntity orderItem1 = new OrderItemsEntity(null, order1, product1, 2, 450.0);
        orderItemsRepository.save(orderItem1);

        OrdersEntity order2 = ordersRepository.findById(1L).orElse(null);
        OrderItemsEntity orderItem2 = new OrderItemsEntity(null, order2, product1, 2, 451.0);
        orderItemsRepository.save(orderItem2);

        OrdersEntity order3 = ordersRepository.findById(1L).orElse(null);
        ProductsEntity product2 = productsRepository.findById(1L).orElse(null);
        OrderItemsEntity orderItem3 = new OrderItemsEntity(null, order3, product2, 2, 123.0);
        orderItemsRepository.save(orderItem3);


        System.out.println("Выполняем логику при создании объекта "
                + this.getClass().getName());
    }

    public List<OrderItemDto> getAllOrderItems() {
        List<OrderItemsEntity> orderItemsEntities = orderItemsRepository.findAll();
        return orderItemsEntities.stream()
                .map(entity -> new OrderItemDto(entity.getOrderItemId(),
                        entity.getOrder().getOrderId(),
                        entity.getProduct().getProductId(),
                        entity.getQuantity(),
                        entity.getPriceAtPurchase()))
                .collect(Collectors.toList());
    }

    public OrderItemDto getOrderItemById(Long id) {
        OrderItemsEntity orderItemsEntity = orderItemsRepository.findById(id).orElse(new OrderItemsEntity());
        return new OrderItemDto(orderItemsEntity.getOrderItemId(),
                orderItemsEntity.getOrder().getOrderId(),
                orderItemsEntity.getProduct().getProductId(),
                orderItemsEntity.getQuantity(),
                orderItemsEntity.getPriceAtPurchase());
    }
    /*
        public FavoriteDto getFavoriteByName(String name) { ///categories/get?name=Other,k=2
            //CategoriesEntity categoriesEntity = categoriesRepository.findByName(name); // используем OQL
            CategoriesEntity categoriesEntity = categoriesRepository.findByNameNative(name); // используем native SQL

            return new FavoriteDto(categoriesEntity.getCategoryId(), categoriesEntity.getName());
        }
    */
    public boolean createOrderItem(OrderItemDto newOrderItem) { //insert
        OrderItemsEntity createOrderItemsEntity = new OrderItemsEntity(null,
                ordersRepository.findById(newOrderItem.getOrderId()).orElse(null),
                productsRepository.findById(newOrderItem.getProductId()).orElse(null),
                newOrderItem.getQuantity(),
                newOrderItem.getPriceAtPurchase());
        OrderItemsEntity returnOrderItemsEntity = orderItemsRepository.save(createOrderItemsEntity);
        return returnOrderItemsEntity.getOrderItemId() != null;
    }

    public OrderItemDto updateOrderItem(OrderItemDto updOrderItem) { //update
        OrderItemsEntity createOrderItemEntity = new OrderItemsEntity(
                updOrderItem.getOrderItemId(),
                ordersRepository.findById(updOrderItem.getOrderId()).orElse(null),
                productsRepository.findById(updOrderItem.getProductId()).orElse(null),
                updOrderItem.getQuantity(),
                updOrderItem.getPriceAtPurchase());

        OrderItemsEntity returnOrderItemEntity = orderItemsRepository.save(createOrderItemEntity);
        // трансформируем данные из Entity в Dto и возвращаем пользователю
        return new OrderItemDto(returnOrderItemEntity.getOrderItemId(),
                returnOrderItemEntity.getOrder().getOrderId(),
                returnOrderItemEntity.getProduct().getProductId(),
                returnOrderItemEntity.getQuantity(),
                returnOrderItemEntity.getPriceAtPurchase());
    }

    public void deleteOrderItem(Long id) { //delete
        // favoritesRepository.deleteById(id); //первый вариант реализации Delete, менее информативно

        //второй вариант реализации Delete
        OrderItemsEntity orderItems = orderItemsRepository.findById(id).orElse(null);
        if(orderItems == null) {
            throw new RuntimeException("Нет такого объекта с Id = "+id);
        } else {
            orderItemsRepository.delete(orderItems);
        }
    }

    @PreDestroy
    void destroy() {
        orderItemDtoList.clear();
        System.out.println("Выполняем логику при окончании работы с  объектом "+this.getClass().getName());
    }

}
