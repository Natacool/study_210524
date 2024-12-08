package de.telran.onlineshop.repository;

import de.telran.onlineshop.entity.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
//import org.springframework.data.repository.CrudRepository;

//interface CategoriesRepository
//        extends CrudRepository<CategoriesEntity, Long> {
//}

@Repository
public interface CategoriesRepository
        extends JpaRepository<CategoriesEntity, Long> {

    @Query("SELECT ce FROM CategoriesEntity ce WHERE ce.name=?1")
    CategoriesEntity findByName(String name);

    // Чистый SQL
    @Query(value = "SELECT * FROM Categories ce WHERE ce.Name=?1", nativeQuery = true)
    CategoriesEntity findByNameNative(String name);



}
