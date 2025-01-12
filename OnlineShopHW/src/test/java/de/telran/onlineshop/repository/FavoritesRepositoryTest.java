package de.telran.onlineshop.repository;

import de.telran.onlineshop.entity.CategoriesEntity;
import de.telran.onlineshop.entity.FavoritesEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FavoritesRepositoryTest {
    @Autowired
    private FavoritesRepository favoritesRepositoryTest;

    @Test
    void findAllTest() {
        List<FavoritesEntity> favoritesTest = favoritesRepositoryTest.findAll();
        assertNotNull(favoritesTest);
        //assertTrue(categoriesTest.size() > 0);
    }

}