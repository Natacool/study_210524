package de.telran.onlineshop.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Orders")
@AllArgsConstructor
@NoArgsConstructor
//@Data
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CartItemsEntity {

    @Id
    @Column(name = "CartItemID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;

    @ManyToOne//(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "CartID")
    private CartEntity cart;

    @ManyToOne//(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "ProductID")
    private ProductsEntity product;

    @Column(name = "Quantity")
    private Integer quantity;
}
