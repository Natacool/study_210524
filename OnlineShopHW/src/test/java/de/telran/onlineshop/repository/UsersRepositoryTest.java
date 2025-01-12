package de.telran.onlineshop.repository;

import de.telran.onlineshop.entity.CategoriesEntity;
import de.telran.onlineshop.entity.UsersEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsersRepositoryTest {
    @Autowired
    private UsersRepository usersRepositoryTest;

    @Test
    void findAllTest() {
        List<UsersEntity> usersTest = usersRepositoryTest.findAll();
        assertNotNull(usersTest);
        //assertTrue(categoriesTest.size() > 0);
    }

    @Test
    void findByNameNativeTest() {
    }
}