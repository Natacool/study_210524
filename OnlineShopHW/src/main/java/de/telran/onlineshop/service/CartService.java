package de.telran.onlineshop.service;

import de.telran.onlineshop.dto.CartDto;
import de.telran.onlineshop.dto.CartItemDto;
import de.telran.onlineshop.dto.FavoriteDto;
import de.telran.onlineshop.entity.CartEntity;
import de.telran.onlineshop.entity.FavoritesEntity;
import de.telran.onlineshop.entity.ProductsEntity;
import de.telran.onlineshop.entity.UsersEntity;
import de.telran.onlineshop.repository.CartRepository;
import de.telran.onlineshop.repository.UsersRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final UsersRepository usersRepository;
    private List<CartDto> cartDtoList;

    @PostConstruct
    void init() {
        // creation in UserService with a user creation, because a cart belongs to the user

        System.out.println("Выполняем логику при создании объекта "
                + this.getClass().getName());

    }

    public List<CartDto> getAllCarts() {
        List<CartEntity> cartEntities = cartRepository.findAll();
        return cartEntities.stream()
                .map(entity -> new CartDto())//entity.getCartId(), entity.getUser().getUserId()))
                .collect(Collectors.toList());
    }

    public CartDto getCartById(Long id) {
        CartEntity cartEntity = cartRepository.findById(id).orElse(new CartEntity()); // new CategoriesEntity() or null
        //UsersEntity cartEntity = usersRepository.findById(id).orElse(new UsersEntity());
        return new CartDto();//cartEntity.getCartId(), cartEntity.getUser().getUserId());
    }
    /*
        public FavoriteDto getFavoriteByName(String name) { ///categories/get?name=Other,k=2
            //CategoriesEntity categoriesEntity = categoriesRepository.findByName(name); // используем OQL
            CategoriesEntity categoriesEntity = categoriesRepository.findByNameNative(name); // используем native SQL

            return new FavoriteDto(categoriesEntity.getCategoryId(), categoriesEntity.getName());
        }
    */
    public boolean createCart(CartDto newCart) { //insert
        CartEntity createCartEntity = new CartEntity();//null,
                //usersRepository.findById(newCart.getUserId()).orElse(null),
                //);
        CartEntity returnCartEntity = cartRepository.save(createCartEntity);
        return returnCartEntity.getCartId() != null;
    }

    public CartDto updateCart(CartDto updCart) { //update
        CartEntity updateCartEntity = new CartEntity();//updCart.getCartId());
        CartEntity returnCartEntity = cartRepository.save(updateCartEntity);
        // трансформируем данные из Entity в Dto и возвращаем пользователю
        return new CartDto(returnCartEntity.getCartId());
    }

    public void deleteCart(Long id) { //delete
        // favoritesRepository.deleteById(id); //первый вариант реализации Delete, менее информативно

        //второй вариант реализации Delete
        CartEntity cart = cartRepository.findById(id).orElse(null);
        if(cart == null) {
            throw new RuntimeException("Нет такого объекта с Id = "+id);
        } else {
            cartRepository.delete(cart);
        }

    }

    @PreDestroy
    void destroy() {
        cartDtoList.clear();
        System.out.println("Выполняем логику при окончании работы с  объектом "+this.getClass().getName());
    }

}
