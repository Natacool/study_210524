package de.telran.onlineshop.dto;

import jakarta.validation.constraints.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CategoryDto {
    //@Min(value = 0)
    @PositiveOrZero(message = "Invalid CategoryId: must be >= 0")
    private Long categoryId;

    @NotNull(message = "Invalid Category Name: NULL")
    @NotEmpty(message = "Invalid Category Name: empty name")
    @Size(min = 2, max = 30, message = "Invalid Category Name: must be of 2-30 characters")
    private String name;

    @NotNull(message = "Invalid Category products list: NULL")
    private Set<ProductDto> products = new HashSet<>();

    public CategoryDto() {
    }

    public CategoryDto(long categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
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
