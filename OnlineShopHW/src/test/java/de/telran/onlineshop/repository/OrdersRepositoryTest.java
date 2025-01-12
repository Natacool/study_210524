package de.telran.onlineshop.repository;

import de.telran.onlineshop.entity.CategoriesEntity;
import de.telran.onlineshop.entity.OrdersEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrdersRepositoryTest {
    @Autowired
    private OrdersRepository ordersRepositoryTest;

    @Test
    void findAllTest() {
        List<OrdersEntity> ordersTest = ordersRepositoryTest.findAll();
        assertNotNull(ordersTest);
        //assertTrue(categoriesTest.size() > 0);
    }

}