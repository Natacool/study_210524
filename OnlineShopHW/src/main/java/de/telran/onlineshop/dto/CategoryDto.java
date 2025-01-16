package de.telran.onlineshop.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Schema(description = "Сущность категории")
public class CategoryDto {
    @Schema(description = "Уникальный идентификатор категории", example = "2", accessMode = Schema.AccessMode.READ_ONLY)
    //@Min(value = 0)
    @PositiveOrZero(message = "Invalid CategoryId: must be >= 0")
    private Long categoryId;

    @Schema(description = "Наименование категории", example = "Новая категория")
    @NotNull(message = "Invalid Category Name: NULL")
    @NotEmpty(message = "Invalid Category Name: empty name")
    @Size(min = 2, max = 30, message = "Invalid Category Name: must be of 2-30 characters")
    private String name;

    @Schema(description = "List of Products in a Category", example = "{Product1, Product2}")
    @NotNull(message = "Invalid Category products list: NULL")
    private Set<ProductDto> products = new HashSet<>();

    public CategoryDto() {
    }

    public CategoryDto(long categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public Set<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductDto> products) {
        this.products = products;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryDto that)) return false;
        return getCategoryId() == that.getCategoryId() && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCategoryId(), getName());
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                '}';
    }
}
