package de.telran.onlineshop.service;

import de.telran.onlineshop.dto.CategoryDto;
import de.telran.onlineshop.dto.FavoriteDto;
import de.telran.onlineshop.dto.ProductDto;
import de.telran.onlineshop.dto.UserDto;
import de.telran.onlineshop.entity.FavoritesEntity;
import de.telran.onlineshop.entity.ProductsEntity;
import de.telran.onlineshop.entity.UsersEntity;
import de.telran.onlineshop.repository.FavoritesRepository;
import de.telran.onlineshop.repository.ProductsRepository;
import de.telran.onlineshop.repository.UsersRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FavoritesService {
    private final UsersRepository usersRepository;
    private final ProductsRepository productsRepository;
    private final FavoritesRepository favoritesRepository;

    @PostConstruct
    void init() {
        UsersEntity user1 = usersRepository.findById(1L).orElse(null);
        ProductsEntity product1 = productsRepository.findById(2L).orElse(null);
        FavoritesEntity favorite1 = new FavoritesEntity(null, user1, product1);
        favoritesRepository.save(favorite1);

        ProductsEntity product2 = productsRepository.findById(1L).orElse(null);
        FavoritesEntity favorite2 = new FavoritesEntity(null, user1, product2);
        favoritesRepository.save(favorite2);

        System.out.println("Выполняем логику при создании объекта "
                + this.getClass().getName());
    }

    public List<FavoriteDto> getAllFavorites() {
        List<FavoritesEntity> favoritesEntities = favoritesRepository.findAll();
        return favoritesEntities.stream()
                .map(entity -> new FavoriteDto(entity.getFavoriteId(),
                        new UserDto(entity.getUser().getUserId(), entity.getUser().getName(),
                                entity.getUser().getEmail(), entity.getUser().getPhoneNumber(),
                                entity.getUser().getPasswordHash()),
                        new ProductDto(entity.getProduct().getProductId(),
                                entity.getProduct().getName(),
                                entity.getProduct().getDescription(),
                                entity.getProduct().getPrice(),
                                entity.getProduct().getImageUrl(),
                                entity.getProduct().getDiscountPrice(),
                                entity.getProduct().getCreatedAt(),
                                entity.getProduct().getUpdatedAt(),
                                new CategoryDto(entity.getProduct().getCategory().getCategoryId(),
                                        entity.getProduct().getCategory().getName()))))
                .collect(Collectors.toList());
    }

    public FavoriteDto getFavoriteById(Long id) {
        FavoritesEntity favoritesEntity = favoritesRepository.findById(id).orElse(new FavoritesEntity()); // new CategoriesEntity() or null
        return new FavoriteDto(favoritesEntity.getFavoriteId(),
                new UserDto(favoritesEntity.getUser().getUserId(), favoritesEntity.getUser().getName(),
                        favoritesEntity.getUser().getEmail(), favoritesEntity.getUser().getPhoneNumber(),
                        favoritesEntity.getUser().getPasswordHash()),
                new ProductDto(favoritesEntity.getProduct().getProductId(),
                        favoritesEntity.getProduct().getName(),
                        favoritesEntity.getProduct().getDescription(),
                        favoritesEntity.getProduct().getPrice(),
                        favoritesEntity.getProduct().getImageUrl(),
                        favoritesEntity.getProduct().getDiscountPrice(),
                        favoritesEntity.getProduct().getCreatedAt(),
                        favoritesEntity.getProduct().getUpdatedAt(),
                        new CategoryDto(favoritesEntity.getProduct().getCategory().getCategoryId(),
                                favoritesEntity.getProduct().getCategory().getName())));
    }
/*
    public FavoriteDto getFavoriteByName(String name) { ///categories/get?name=Other,k=2
        //CategoriesEntity categoriesEntity = categoriesRepository.findByName(name); // используем OQL
        CategoriesEntity categoriesEntity = categoriesRepository.findByNameNative(name); // используем native SQL

        return new FavoriteDto(categoriesEntity.getCategoryId(), categoriesEntity.getName());
    }
*/
    public boolean createFavorite(FavoriteDto newFavorite) { //insert
        FavoritesEntity createFavoriteEntity = new FavoritesEntity(null,
                usersRepository.findById(newFavorite.getUser().getUserId()).orElse(null),
                productsRepository.findById(newFavorite.getProduct().getProductId()).orElse(null));
        FavoritesEntity returnFavoriteEntity = favoritesRepository.save(createFavoriteEntity);

        return returnFavoriteEntity.getFavoriteId() != null;
    }

    public FavoriteDto updateFavorite(FavoriteDto updFavorite) { //update
        FavoritesEntity createFavoriteEntity = new FavoritesEntity(
                updFavorite.getFavoriteId(),
                usersRepository.findById(updFavorite.getUser().getUserId()).orElse(null),
                productsRepository.findById(updFavorite.getProduct().getProductId()).orElse(null));

        FavoritesEntity returnFavoriteEntity = favoritesRepository.save(createFavoriteEntity);
        // трансформируем данные из Entity в Dto и возвращаем пользователю
        return new FavoriteDto(returnFavoriteEntity.getFavoriteId(),
                new UserDto(returnFavoriteEntity.getUser().getUserId(), returnFavoriteEntity.getUser().getName(),
                        returnFavoriteEntity.getUser().getEmail(), returnFavoriteEntity.getUser().getPhoneNumber(),
                        returnFavoriteEntity.getUser().getPasswordHash()),
                new ProductDto(returnFavoriteEntity.getProduct().getProductId(),
                        returnFavoriteEntity.getProduct().getName(),
                        returnFavoriteEntity.getProduct().getDescription(),
                        returnFavoriteEntity.getProduct().getPrice(),
                        returnFavoriteEntity.getProduct().getImageUrl(),
                        returnFavoriteEntity.getProduct().getDiscountPrice(),
                        returnFavoriteEntity.getProduct().getCreatedAt(),
                        returnFavoriteEntity.getProduct().getUpdatedAt(),
                        new CategoryDto(returnFavoriteEntity.getProduct().getCategory().getCategoryId(),
                                returnFavoriteEntity.getProduct().getCategory().getName())));
    }

    public void deleteFavorite(Long id) { //delete
        // favoritesRepository.deleteById(id); //первый вариант реализации Delete, менее информативно

        //второй вариант реализации Delete
        FavoritesEntity favorite = favoritesRepository.findById(id).orElse(null);
        if(favorite == null) {
            throw new RuntimeException("Нет такого объекта с Id = "+id);
        } else {
            favoritesRepository.delete(favorite);
        }

    }

    @PreDestroy
    void destroy() {
        System.out.println("Выполняем логику при окончании работы с  объектом "+this.getClass().getName());
    }


}
