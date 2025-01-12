package de.telran.onlineshop.repository;

import de.telran.onlineshop.entity.CartEntity;
import de.telran.onlineshop.entity.CategoriesEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartRepositoryTest {
    @Autowired
    private CartRepository cartRepositoryTest;

    private static final String NAME_TEST = "Test";
    private static CartEntity categoriesEntityNewTest;


    @Test
    void findAllTest() {
        List<CartEntity> cartEntityTest = cartRepositoryTest.findAll();
        assertNotNull(cartEntityTest);
        //assertTrue(categoriesTest.size() > 0);
    }

    @Test
    void insertTest() {
        String nameExpected = NAME_TEST;
        CartEntity cartEntityTest = categoriesEntityNewTest;

        CartEntity cartEntityActual = categoriesRepositoryTest.save(categoriesTest);

        assertNotNull(categoriesActual);
        assertTrue(categoriesActual.getCategoryId() != null);
        assertEquals(nameExpected, categoriesActual.getName());
    }

    @Test
    void updateTest() {
        // when
        CategoriesEntity categoriesExpected = generateTestData();

        // test
        String nameExpected = "NewTest";
        // if(true) throw new NullPointerException("Imitation");
        categoriesExpected.setName(nameExpected);
        CategoriesEntity categoriesActual = categoriesRepositoryTest.save(categoriesExpected);

        //assert
        assertNotNull(categoriesActual);
        assertEquals(nameExpected, categoriesActual.getName());

    }



}