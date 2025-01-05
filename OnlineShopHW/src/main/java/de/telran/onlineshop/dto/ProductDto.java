package de.telran.onlineshop.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

/*
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
*/
public class ProductDto {
    private Long productId;
    private String name;
    private String description;
    private Double price;
    //private CategoryDto categoryId;
    private Long categoryId;
    private String imageUrl;
    private Double discountPrice;
    private Timestamp createdAt;
    private Timestamp updatedAt;


    public ProductDto() {
    }

    public ProductDto(Long productId, String name,
                      String description, Double price,
                      //CategoryDto categoryId, String imageUrl,
                      Long categoryId, String imageUrl,
                      Double discountPrice) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
        this.imageUrl = imageUrl;
        this.discountPrice = discountPrice;
        createdAt = Timestamp.valueOf(LocalDateTime.now());
        updatedAt = createdAt;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
        updatedAt = Timestamp.valueOf(LocalDateTime.now());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        updatedAt = Timestamp.valueOf(LocalDateTime.now());
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        updatedAt = Timestamp.valueOf(LocalDateTime.now());
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
        updatedAt = Timestamp.valueOf(LocalDateTime.now());
    }

    //public CategoryDto getCategoryId() {
    //    return categoryId;
    //}
    public Long getCategoryId() {
        return categoryId;
    }

    //public void setCategoryId(CategoryDto categoryId) {
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
        updatedAt = Timestamp.valueOf(LocalDateTime.now());
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        updatedAt = Timestamp.valueOf(LocalDateTime.now());
    }

    public Double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Double discountPrice) {
        this.discountPrice = discountPrice;
        updatedAt = Timestamp.valueOf(LocalDateTime.now());
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDto product)) return false;
        return getProductId() == product.getProductId()
                && Objects.equals(getName(), product.getName())
                && Objects.equals(getCreatedAt(), product.getCreatedAt());
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
