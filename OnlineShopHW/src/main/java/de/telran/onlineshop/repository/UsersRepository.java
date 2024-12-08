package de.telran.onlineshop.repository;

import de.telran.onlineshop.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {
// add at least one user query either OQL or SQL
}
