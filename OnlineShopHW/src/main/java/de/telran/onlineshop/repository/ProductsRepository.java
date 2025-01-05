package de.telran.onlineshop.repository;

import de.telran.onlineshop.entity.CategoriesEntity;
import de.telran.onlineshop.entity.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsEntity, Long> {
// add at least one user query either OQL or SQL
    @Query("SELECT * FROM Products pe WHERE pe.Name=?1")
    ProductsEntity findByName(String name);
}
