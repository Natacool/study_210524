package de.telran.onlineshop.entity;

import com.fasterxml.jackson.databind.ser.std.TimeZoneSerializer;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Products")
@AllArgsConstructor
@NoArgsConstructor
//@Data
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ProductsEntity {

    @Id
    @Column(name = "ProductID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "Price")
    private Double price;

    @Column(name = "ImageURL")
    private String imageUrl;

    @Column(name = "DiscountPrice")
    private Double discountPrice;

    @Column(name = "CreatedAt")
    private Timestamp createdAt;

    @Column(name = "UpdatedAt")
    private Timestamp updatedAt;

    //    @ManyToOne//(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinColumn(name = "CategoryID") // имя колонки для связи с CategoriesEntity
//    private CategoriesEntity category;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CategoryID")
    private CategoriesEntity category;

    @OneToMany(mappedBy = "order")
    private Set<OrderItemsEntity> orderItems = new HashSet<>();

    @OneToMany(mappedBy = "favorite")//, cascade = CascadeType.ALL)
    private Set<FavoritesEntity> favorites = new HashSet<>();

    @OneToMany(mappedBy = "cartItem")//, cascade = CascadeType.ALL)
    private Set<CartItemsEntity> cartItems = new HashSet<>();

}
