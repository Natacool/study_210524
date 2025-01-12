package de.telran.onlineshop.repository;

import de.telran.onlineshop.entity.CategoriesEntity;
import de.telran.onlineshop.entity.OrderItemsEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemsRepositoryTest {
    @Autowired
    private OrderItemsRepository orderItemsRepositoryTest;

    @Test
    void findAllTest() {
        List<OrderItemsEntity> orderItemsTest = orderItemsRepositoryTest.findAll();
        assertNotNull(orderItemsTest);
        //assertTrue(categoriesTest.size() > 0);
    }

}