package de.telran.onlineshop.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Products {
    private int productId;
    private String name;
    private String description;
    private Float price;
    private int categoryId;
    private String imageUrl;
    private Float discountPrice;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Products() {
    }

    public Products(int productId, String name, String description, Float price, int categoryId, String imageUrl, Float discountPrice) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
        this.imageUrl = imageUrl;
        this.discountPrice = discountPrice;
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
        updatedAt = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        updatedAt = LocalDateTime.now();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        updatedAt = LocalDateTime.now();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
        updatedAt = LocalDateTime.now();
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
        updatedAt = LocalDateTime.now();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        updatedAt = LocalDateTime.now();
    }

    public Float getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Float discountPrice) {
        this.discountPrice = discountPrice;
        updatedAt = LocalDateTime.now();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Products products)) return false;
        return getProductId() == products.getProductId()
                && Objects.equals(getName(), products.getName())
                && Objects.equals(getCreatedAt(), products.getCreatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getName(), getCreatedAt());
    }

    @Override
    public String toString() {
        return "Products{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", categoryId=" + categoryId +
                ", imageUrl='" + imageUrl + '\'' +
                ", discountPrice=" + discountPrice +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
