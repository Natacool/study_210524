package de.telran.onlineshop.service;

import de.telran.onlineshop.dto.*;
import de.telran.onlineshop.entity.FavoritesEntity;
import de.telran.onlineshop.entity.OrdersEntity;
import de.telran.onlineshop.entity.ProductsEntity;
import de.telran.onlineshop.entity.UsersEntity;
import de.telran.onlineshop.entity.enums.Status;
import de.telran.onlineshop.repository.OrdersRepository;
import de.telran.onlineshop.repository.ProductsRepository;
import de.telran.onlineshop.repository.UsersRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class OrdersService {
    private final OrdersRepository ordersRepository;
    private final UsersRepository usersRepository;
    private List<OrderDto> orderDtoList;

    @PostConstruct
    void init() {
        orderDtoList = new ArrayList<>();

        UsersEntity user1 = usersRepository.findById(1L).orElse(null);
        OrdersEntity order1 = new OrdersEntity(null, user1, null, null, null, null, Status.CREATED, null);
        ordersRepository.save(order1);
        UsersEntity user2 = usersRepository.findById(2L).orElse(null);
        OrdersEntity order2 = new OrdersEntity(null, user2, null, null, null, null, Status.CREATED, null);
        ordersRepository.save(order2);

        System.out.println("Выполняем логику при создании объекта "
                + this.getClass().getName());
    }

    public List<OrderDto> getAllOrders() {
        List<OrdersEntity> ordersEntities = ordersRepository.findAll();
        return ordersEntities.stream()
                .map(entity -> new OrderDto(entity.getOrderId(),
                        entity.getUser().getUserId(),
                        //new UserDto(), //????
                        entity.getCreatedAt(),
                        entity.getDeliveryAddress(),
                        entity.getContactPhone(),
                        entity.getDeliveryMethod(),
                        entity.getStatus(),
                        entity.getUpdatedAt()))
                .collect(Collectors.toList());
    }

    public OrderDto getOrderById(Long id) {
        OrdersEntity ordersEntity = ordersRepository.findById(id).orElse(new OrdersEntity()); // new CategoriesEntity() or null
        return new OrderDto(ordersEntity.getOrderId(),
                ordersEntity.getUser().getUserId(),
                ordersEntity.getCreatedAt(),
                ordersEntity.getDeliveryAddress(),
                ordersEntity.getContactPhone(),
                ordersEntity.getDeliveryMethod(),
                ordersEntity.getStatus(),
                ordersEntity.getUpdatedAt());

    }
    /*
        public FavoriteDto getOrderByStatus(String name) { ///categories/get?name=Other,k=2
        public FavoriteDto getOrderByDeliveryAddress(String name) { ///categories/get?name=Other,k=2
        public FavoriteDto getOrderByDeliveryMethod(String name) { ///categories/get?name=Other,k=2
        public FavoriteDto getOrderByCreatedDate(String name) { ///categories/get?name=Other,k=2
        public FavoriteDto getOrderByUpdatedDate(String name) { ///categories/get?name=Other,k=2
        public FavoriteDto getOrderByUser(String name) { ///categories/get?name=Other,k=2

            //CategoriesEntity categoriesEntity = categoriesRepository.findByName(name); // используем OQL
            CategoriesEntity categoriesEntity = categoriesRepository.findByNameNative(name); // используем native SQL

            return new FavoriteDto(categoriesEntity.getCategoryId(), categoriesEntity.getName());
        }
    */
    public boolean createOrder(OrderDto newOrder) { //insert
        OrdersEntity ordersEntity = new OrdersEntity(
                null,
                usersRepository.findById(newOrder.getUserId()).orElse(null),
                newOrder.getCreatedAt(),
                newOrder.getDeliveryAddress(),
                newOrder.getContactPhone(),
                newOrder.getDeliveryMethod(),
                newOrder.getStatus(),
                newOrder.getUpdatedAt());

        OrdersEntity returnOrderEntity = ordersRepository.save(ordersEntity);
        return returnOrderEntity.getOrderId() != null;
    }

    public OrderDto updateOrder(OrderDto updOrder) { //update
        OrdersEntity createOrdersEntity = new OrdersEntity(
                updOrder.getOrderId(),
                usersRepository.findById(updOrder.getUserId()).orElse(null),
                updOrder.getCreatedAt(),
                updOrder.getDeliveryAddress(),
                updOrder.getContactPhone(),
                updOrder.getDeliveryMethod(),
                updOrder.getStatus(),
                updOrder.getUpdatedAt());

        OrdersEntity returnOrdersEntity = ordersRepository.save(createOrdersEntity);
        // трансформируем данные из Entity в Dto и возвращаем пользователю
        return new OrderDto(
                returnOrdersEntity.getOrderId(),
                returnOrdersEntity.getUser().getUserId(),
                returnOrdersEntity.getCreatedAt(),
                returnOrdersEntity.getDeliveryAddress(),
                returnOrdersEntity.getContactPhone(),
                returnOrdersEntity.getDeliveryMethod(),
                returnOrdersEntity.getStatus(),
                returnOrdersEntity.getUpdatedAt());
    }

    public void deleteOrder(Long id) { //delete
        // favoritesRepository.deleteById(id); //первый вариант реализации Delete, менее информативно

        //второй вариант реализации Delete
        OrdersEntity order = ordersRepository.findById(id).orElse(null);
        if(order == null) {
            throw new RuntimeException("Нет такого объекта с Id = "+id);
        } else {
            ordersRepository.delete(order);
        }
    }


    @PreDestroy
    void destroy() {
        orderDtoList.clear();
        System.out.println("Выполняем логику при окончании работы с  объектом "+this.getClass().getName());
    }


}
