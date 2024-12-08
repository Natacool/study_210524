package de.telran.onlineshop.repository;

import de.telran.onlineshop.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {
// add at least one user (search) query either OQL or SQL
}
