package de.telran.onlineshop.repository;

import de.telran.onlineshop.entity.FavoritesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritesRepository extends JpaRepository<FavoritesEntity, Long> {
// add at least one user query either OQL or SQL
}
