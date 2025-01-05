package de.telran.onlineshop.service;

import de.telran.onlineshop.dto.CartItemDto;
import de.telran.onlineshop.dto.CategoryDto;
import de.telran.onlineshop.dto.FavoriteDto;
import de.telran.onlineshop.entity.*;
import de.telran.onlineshop.repository.CartItemsRepository;
import de.telran.onlineshop.repository.CartRepository;
import de.telran.onlineshop.repository.ProductsRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartItemsService {
    private final CartItemsRepository cartItemsRepository;
    private final CartRepository cartRepository;
    private final ProductsRepository productsRepository;
    private List<CartItemDto> cartItemDtoList;
    @PostConstruct
    void init() {
        CartEntity cart1 = cartRepository.findById(1L).orElse(null);
        CartEntity cart2 = cartRepository.findById(2L).orElse(null);
        ProductsEntity product1 = productsRepository.findById(1L).orElse(null);
        ProductsEntity product2 = productsRepository.findById(2L).orElse(null);
        ProductsEntity product4 = productsRepository.findById(4L).orElse(null);

        CartItemsEntity cartItems1 = new CartItemsEntity(null, cart1, product1, 2);
        cartItemsRepository.save(cartItems1);
        CartItemsEntity cartItems2 = new CartItemsEntity(null, cart1, product4, 1);
        cartItemsRepository.save(cartItems2);
        CartItemsEntity cartItems3 = new CartItemsEntity(null, cart2, product2, 4);
        cartItemsRepository.save(cartItems3);
        CartItemsEntity cartItems4 = new CartItemsEntity(null, cart2, product4, 2);
        cartItemsRepository.save(cartItems4);

        System.out.println("Выполняем логику при создании объекта "
                + this.getClass().getName());
    }

    public List<CartItemDto> getAllCartItems() {
        List<CartItemsEntity> cartItemEntities = cartItemsRepository.findAll();
        return cartItemEntities.stream()
                .map(entity -> new CartItemDto(entity.getCartItemId(),
                        entity.getCart().getCartId(),
                        entity.getProduct().getProductId(),
                        entity.getQuantity()))
                .collect(Collectors.toList());
    }

    public CartItemDto getCartItemById(Long id) {
        CartItemsEntity cartItemsEntity = cartItemsRepository.findById(id).orElse(new CartItemsEntity());
        return new CartItemDto(cartItemsEntity.getCartItemId(),
                cartItemsEntity.getCart().getCartId(),
                cartItemsEntity.getProduct().getProductId(),
                cartItemsEntity.getQuantity());
    }
    /*
        public FavoriteDto getFavoriteByName(String name) { ///categories/get?name=Other,k=2
            //CategoriesEntity categoriesEntity = categoriesRepository.findByName(name); // используем OQL
            CategoriesEntity categoriesEntity = categoriesRepository.findByNameNative(name); // используем native SQL

            return new FavoriteDto(categoriesEntity.getCategoryId(), categoriesEntity.getName());
        }
    */
    public boolean createCartItem(CartItemDto newCartItem) { //insert
        CartItemsEntity createCartItemEntity = new CartItemsEntity(null,
                cartRepository.findById(newCartItem.getCartId()).orElse(null),
                productsRepository.findById(newCartItem.getProductId()).orElse(null),
                newCartItem.getQuantity());

        CartItemsEntity returnCartItemEntity = cartItemsRepository.save(createCartItemEntity);
        return returnCartItemEntity.getCartItemId() != null;
    }

    public CartItemDto updateCartItem(CartItemDto updCartItem) { //update
        CartItemsEntity createCartItemEntity = new CartItemsEntity(
                updCartItem.getCartItemId(),
                cartRepository.findById(updCartItem.getCartId()).orElse(null),
                productsRepository.findById(updCartItem.getProductId()).orElse(null),
                updCartItem.getQuantity());

        CartItemsEntity returnCartItemEntity = cartItemsRepository.save(createCartItemEntity);
        // трансформируем данные из Entity в Dto и возвращаем пользователю
        return new CartItemDto(returnCartItemEntity.getCartItemId(),
                returnCartItemEntity.getCart().getCartId(),
                returnCartItemEntity.getProduct().getProductId(),
                returnCartItemEntity.getQuantity());
    }

    public void deleteCartItem(Long id) { //delete
        // cartItemsRepository.deleteById(id); //первый вариант реализации Delete, менее информативно

        //второй вариант реализации Delete
        CartItemsEntity cartItem = cartItemsRepository.findById(id).orElse(null);
        if(cartItem == null) {
            throw new RuntimeException("Нет такого объекта с Id = "+id);
        } else {
            cartItemsRepository.delete(cartItem);
        }

    }

    @PreDestroy
    void destroy() {
        cartItemDtoList.clear();
        System.out.println("Выполняем логику при окончании работы с  объектом "+this.getClass().getName());
    }

}
