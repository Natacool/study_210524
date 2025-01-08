package de.telran.onlineshop.service;

import de.telran.onlineshop.dto.CategoryDto;
import de.telran.onlineshop.dto.ProductDto;
import de.telran.onlineshop.entity.CategoriesEntity;
import de.telran.onlineshop.entity.ProductsEntity;
import de.telran.onlineshop.repository.CategoriesRepository;
import de.telran.onlineshop.repository.ProductsRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ProductsService {
    private final ProductsRepository productsRepository;
    private final CategoriesRepository categoriesRepository;

    @PostConstruct
    void init() {

        //ProductsEntity product1 = new ProductsEntity();
                //null, "Product1", "Description of product1"
                //, 123.45F, 1L, "", null, null);
        //product1 = productsRepository.save(product1);

        CategoriesEntity category1 = categoriesRepository.findById(1L).orElse(null);
        ProductsEntity product1 = new ProductsEntity(null, "Product1",
                "Description of product1",
                123.45, "", 120.15, null, null,
                category1, null, null, null);
        productsRepository.save(product1);

        ProductsEntity product2 = new ProductsEntity(null, "Product2",
                "Description of product2",
                234.23, "", 230.0, null, null,
                category1, null, null, null);
        productsRepository.save(product2);

        CategoriesEntity category2 = categoriesRepository.findById(1L).orElse(null);
        ProductsEntity product3 = new ProductsEntity(null, "Product3",
                "Description of product3",
                234.23, "", 230.0, null, null,
                category2, null, null, null);
        productsRepository.save(product3);

        CategoriesEntity category3 = categoriesRepository.findById(1L).orElse(null);
        ProductsEntity product4 = new ProductsEntity(null, "Product4",
                "Description of product4",
                123.45, "", 121.0, null, null,
                category3, null, null, null);
        productsRepository.save(product4);

        ProductsEntity product5 = new ProductsEntity(null, "Product5",
                "Description of product5",
                234.23, "", 229.0, null, null,
                category2, null, null, null);
        productsRepository.save(product5);

        System.out.println("Run code during creating an object: "
                + this.getClass().getName());
    }

    public List<ProductDto> getAllProducts() {

        List<ProductsEntity> productsEntities = productsRepository.findAll();
        return productsEntities.stream()
                .map(entity -> ProductDto.builder()
                        .productId(entity.getProductId())
                        .name(entity.getName())
                        .build())
                .collect(Collectors.toList());

/*
        List<ProductsEntity> productsEntities = productsRepository.findAll();
        return productsEntities.stream()
                .map(entity -> new ProductDto(entity.getProductId(),
                        entity.getName(),
                        entity.getDescription(),
                        entity.getPrice(),
                        entity.getImageUrl(),
                        entity.getDiscountPrice(),
                        entity.getCreatedAt(),
                        entity.getUpdatedAt(),
                        new CategoryDto(entity.getCategory().getCategoryId(),
                                entity.getCategory().getName())
                        ))
                .collect(Collectors.toList());
*/
    }


    public ProductDto getProductById(Long id) { ///users/find/3
        ProductsEntity productsEntity = productsRepository.findById(id).orElse(new ProductsEntity());

        return ProductDto.builder()
                .productId(productsEntity.getProductId())
                .name(productsEntity.getName())
                .build();

/*
        return new ProductDto(productsEntity.getProductId(),
                productsEntity.getName(),
                productsEntity.getDescription(),
                productsEntity.getPrice(),
                productsEntity.getImageUrl(),
                productsEntity.getDiscountPrice(),
                productsEntity.getCreatedAt(),
                productsEntity.getUpdatedAt(),
                new CategoryDto(productsEntity.getCategory().getCategoryId(),
                        productsEntity.getCategory().getName()));
*/
    }

    public ProductDto getProductByName(String name) { ///users/get?name=Other,k=2
        ProductsEntity productsEntity = productsRepository.findByName(name);

        return new ProductDto(productsEntity.getProductId(),
                productsEntity.getName(),
                productsEntity.getDescription(),
                productsEntity.getPrice(),
                productsEntity.getImageUrl(),
                productsEntity.getDiscountPrice(),
                productsEntity.getCreatedAt(),
                productsEntity.getUpdatedAt(),
                new CategoryDto(productsEntity.getCategory().getCategoryId(),
                        productsEntity.getCategory().getName()));
    }

    public boolean createProduct(ProductDto newProduct) { //insert
        ProductsEntity createProductEntity = new ProductsEntity(null,
                newProduct.getName(),
                newProduct.getDescription(),
                newProduct.getPrice(),
                newProduct.getImageUrl(),
                newProduct.getDiscountPrice(),
                newProduct.getCreatedAt(),
                newProduct.getUpdatedAt(),
                new CategoriesEntity(newProduct.getCategory().getCategoryId(),
                        newProduct.getCategory().getName()),
                null,
                null,
                null);
        ProductsEntity returnProductEntity = productsRepository.save(createProductEntity);
        return returnProductEntity.getProductId() != null;
   }

    public ProductDto updateProduct(ProductDto updProduct) { //update
        ProductsEntity updateProductEntity = new ProductsEntity(updProduct.getProductId(),
                updProduct.getName(),
                updProduct.getDescription(),
                updProduct.getPrice(),
                updProduct.getImageUrl(),
                updProduct.getDiscountPrice(),
                updProduct.getCreatedAt(),
                updProduct.getUpdatedAt(),
                new CategoriesEntity(updProduct.getCategory().getCategoryId(),
                        updProduct.getCategory().getName()),
                null,
                null,
                null);

        ProductsEntity returnProductEntity = productsRepository.save(updateProductEntity);

        // трансформируем данные из Entity в Dto и возвращаем пользователю
        return new ProductDto(returnProductEntity.getProductId(),
                returnProductEntity.getName(),
                returnProductEntity.getDescription(),
                returnProductEntity.getPrice(),
                returnProductEntity.getImageUrl(),
                returnProductEntity.getDiscountPrice(),
                returnProductEntity.getCreatedAt(),
                returnProductEntity.getUpdatedAt(),
                new CategoryDto(returnProductEntity.getCategory().getCategoryId(),
                        returnProductEntity.getCategory().getName()));
    }

    public void deleteProduct(Long id) { //delete
        //productsRepository.deleteById(id); //первый вариант реализации Delete, менее информативно

        //второй вариант реализации Delete
        ProductsEntity product = productsRepository.findById(id).orElse(null);
        if(product == null) {
            throw new RuntimeException("Нет такого объекта с Id = " + id);
        } else {
            productsRepository.delete(product);
        }
    }

    public void destroy() {
        System.out.println("Run code after finishing work with the object: "
                + this.getClass().getName());
    }
}
