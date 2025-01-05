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

    @Column(name = "CreatedAt")
    private Timestamp createdAt;

    @Column(name = "DeliveryAddress")
    private String deliveryAddress;

    @Column(name = "ContactPhone")
    private String contactPhone;

    @Column(name = "DeliveryMethod")
    private String deliveryMethod;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status")
    private Status status;

    @Column(name = "UpdatedAt")
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "order")//, cascade = CascadeType.ALL)
    private Set<OrderItemsEntity> orderItems = new HashSet<>();

    public OrdersEntity(Long id, UsersEntity user, Timestamp createdAt,
                        String deliveryAddress, String contactPhone,
                        String deliveryMethod, Status status, Timestamp updatedAt) {
        this.orderId = id;
        this.user = user;
        this.createdAt = createdAt;
        this.deliveryAddress = deliveryAddress;
        this.contactPhone = contactPhone;
        this.deliveryMethod = deliveryMethod;
        this.status = status;
        this.updatedAt = updatedAt;
    }
}
