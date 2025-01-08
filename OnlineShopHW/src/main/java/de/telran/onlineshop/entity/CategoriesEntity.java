package de.telran.onlineshop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Categories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CategoriesEntity {

    @Id
    @Column(name = "CategoryID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column(name = "Name")
    @NotNull
    @NotBlank
    private String name;

//    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
// , fetch = FetchType.EAGER - load all data from DB even from joined tables
    @OneToMany(mappedBy = "category")//, cascade = CascadeType.ALL)
    private Set<ProductsEntity> products = new HashSet<>();

    public CategoriesEntity(Long categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }
}
