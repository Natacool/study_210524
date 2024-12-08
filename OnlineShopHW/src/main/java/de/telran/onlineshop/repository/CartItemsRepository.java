package de.telran.onlineshop.repository;

import de.telran.onlineshop.entity.CartItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItemsEntity, Long> {
// add at least one user query either OQL or SQL
}
