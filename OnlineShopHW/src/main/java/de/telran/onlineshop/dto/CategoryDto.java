package de.telran.onlineshop.dto;

import java.util.Objects;

public class CategoryDto {
    private Long categoryId;
    private String name;

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
