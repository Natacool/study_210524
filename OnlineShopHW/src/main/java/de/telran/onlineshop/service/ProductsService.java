package de.telran.onlineshop.service;

import de.telran.onlineshop.dto.CategoryDto;
import de.telran.onlineshop.dto.ProductDto;
import de.telran.onlineshop.entity.CategoriesEntity;
import de.telran.onlineshop.entity.ProductsEntity;
import de.telran.onlineshop.repository.CategoriesRepository;
import de.telran.onlineshop.repository.ProductsRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ProductsService {
    private final ProductsRepository productsRepository;
    private List<ProductDto> productDtoList;
    @PostConstruct
    void init() {
        productDtoList = new ArrayList<>();

        ProductsEntity product1 = new ProductsEntity();
                //null, "Product1", "Description of product1"
                //, 123.45F, 1L, "", null, null);
        product1 = productsRepository.save(product1);


        productDtoList.add(new ProductDto(1, "Product1", "Description of product1", 123.45, 1, "", null));
        productDtoList.add(new ProductDto(2, "Product2", "Description of product2", 456.01, 1, "", null));
        productDtoList.add(new ProductDto(3, "Product3", "Description of product3", 234.23, 2, "", null));
        productDtoList.add(new ProductDto(4, "Product4", "Description of product4", 123.45, 3, "", null));
        productDtoList.add(new ProductDto(5, "Product5", "Description of product5", 234.23, 2, "", null));

        System.out.println("Run code during creating an object: "
                + this.getClass().getName());
    }

    public List<ProductDto> getAllProducts() {
        List<ProductsEntity> productsEntities = productsRepository.findAll();
        return productsEntities.stream()
                .map(entity -> new ProductDto(
                        entity.getProductId()
                        , entity.getName()
                        , entity.getDescription()
                        , entity.getPrice()
                        , entity.getProductId()
                        , entity.getImageUrl()
                        , entity.getDiscountPrice()
                        ))
                .collect(Collectors.toList());
    }

}
