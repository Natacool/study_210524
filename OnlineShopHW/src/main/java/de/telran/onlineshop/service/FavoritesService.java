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
                        , entity.getUser().getUserId()
                        , entity.getProduct().getProductId()))
                .collect(Collectors.toList());
    }

    public FavoriteDto getFavoriteById(Long id) {
        FavoritesEntity favoritesEntity = favoritesRepository.findById(id).orElse(new FavoritesEntity()); // new CategoriesEntity() or null
        return new FavoriteDto(favoritesEntity.getFavoriteId(),
                favoritesEntity.getUser().getUserId(),
                favoritesEntity.getProduct().getProductId());
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
                usersRepository.findById(newFavorite.getUserId()).orElse(null),
                productsRepository.findById(newFavorite.getProductId()).orElse(null));
        FavoritesEntity returnFavoriteEntity = favoritesRepository.save(createFavoriteEntity);

        return returnFavoriteEntity.getFavoriteId() != null;
    }

    public FavoriteDto updateFavorite(FavoriteDto updFavorite) { //update
        FavoritesEntity createFavoriteEntity = new FavoritesEntity(
                updFavorite.getFavoriteId(),
                usersRepository.findById(updFavorite.getUserId()).orElse(null),
                productsRepository.findById(updFavorite.getProductId()).orElse(null));

        FavoritesEntity returnFavoriteEntity = favoritesRepository.save(createFavoriteEntity);
        // трансформируем данные из Entity в Dto и возвращаем пользователю
        return new FavoriteDto(returnFavoriteEntity.getFavoriteId(),
                returnFavoriteEntity.getUser().getUserId(),
                returnFavoriteEntity.getProduct().getProductId());
    }

    public void deleteCategories(Long id) { //delete
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
        categoryList.clear();
        System.out.println("Выполняем логику при окончании работы с  объектом "+this.getClass().getName());
    }


}
