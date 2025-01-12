package de.telran.onlineshop.repository;

import de.telran.onlineshop.entity.CategoriesEntity;
import de.telran.onlineshop.entity.ProductsEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductsRepositoryTest {
    @Autowired
    private ProductsRepository productsRepositoryTest;

    @Test
    void findAllTest() {
        List<ProductsEntity> productsTest = productsRepositoryTest.findAll();
        assertNotNull(productsTest);
        //assertTrue(categoriesTest.size() > 0);
    }

    @Test
    void findByNameTest() {
    }

}