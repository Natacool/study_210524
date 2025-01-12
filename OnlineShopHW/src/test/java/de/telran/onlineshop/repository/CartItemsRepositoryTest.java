package de.telran.onlineshop.repository;

import de.telran.onlineshop.entity.CartItemsEntity;
import de.telran.onlineshop.entity.CategoriesEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartItemsRepositoryTest {

    @Autowired
    private CartItemsRepository cartItemsRepositoryTest;

    @Test
    void findAllTest() {
        List<CartItemsEntity> cartItemsTest = cartItemsRepositoryTest.findAll();
        assertNotNull(cartItemsTest);
        //assertTrue(categoriesTest.size() > 0);
    }

}