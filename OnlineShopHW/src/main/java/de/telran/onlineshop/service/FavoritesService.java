package de.telran.onlineshop.service;

import de.telran.onlineshop.dto.CategoryDto;
import de.telran.onlineshop.dto.FavoriteDto;
import de.telran.onlineshop.entity.CategoriesEntity;
import de.telran.onlineshop.entity.FavoritesEntity;
import de.telran.onlineshop.entity.ProductsEntity;
import de.telran.onlineshop.entity.UsersEntity;
import de.telran.onlineshop.repository.CategoriesRepository;
import de.telran.onlineshop.repository.FavoritesRepository;
import de.telran.onlineshop.repository.ProductsRepository;
import de.telran.onlineshop.repository.UsersRepository;
import jakarta.annotation.PostConstruct;
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
    private List<FavoriteDto> favoriteDtoList;

    @PostConstruct
    void init() {
        UsersEntity user1 = usersRepository.findById(1L).orElse(null);
        ProductsEntity product1 = productsRepository.findById(2L).orElse(null);
        //FavoritesEntity favorite1 = new FavoritesEntity(null, user1, product1);
        FavoritesEntity favorite1 = new FavoritesEntity();
        favoritesRepository.save(favorite1);

        ProductsEntity product2 = productsRepository.findById(1L).orElse(null);
        //FavoritesEntity favorite2 = new FavoritesEntity(null, user1, product2);
        FavoritesEntity favorite2 = new FavoritesEntity();
        favoritesRepository.save(favorite2);

        System.out.println("Выполняем логику при создании объекта "
                + this.getClass().getName());
    }

    public List<FavoriteDto> getAllFavorites() {
        List<FavoritesEntity> favoritesEntities = favoritesRepository.findAll();
        return favoritesEntities.stream()
                .map(entity -> new FavoriteDto(entity.getFavoriteId()
                        , entity.getUserId()
                        , entity.getProductId()))
                .collect(Collectors.toList());
    }



}
