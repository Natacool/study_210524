package de.telran.onlineshop.repository;

import de.telran.onlineshop.entity.OrderItemsEntity;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItemsEntity, Long> {
// add at least one user query either OQL or SQL
}
