package de.telran.onlineshop.entity;


import de.telran.onlineshop.entity.enums.Role;
import de.telran.onlineshop.entity.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Orders")
@AllArgsConstructor
@NoArgsConstructor
//@Data
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class OrdersEntity {

    @Id
    @Column(name = "OrderID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne//(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "UserID")
    private UsersEntity user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderItemsEntity> orderItems = new HashSet<>();

    @Column(name = "CreatedAt")
    private Timestamp createdAt;

    @Column(name = "DeliveryAddress")
    private Timestamp deliveryAddress;

    @Column(name = "ContactPhone")
    private Timestamp contactPhone;

    @Column(name = "DeliveryMethod")
    private Timestamp deliveryMethod;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status")
    private Status status;

    @Column(name = "UpdatedAt")
    private Timestamp updatedAt;

}
