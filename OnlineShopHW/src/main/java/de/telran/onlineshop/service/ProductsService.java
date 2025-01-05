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
    private List<ProductDto> productDtoList;
    @PostConstruct
    void init() {
        productDtoList = new ArrayList<>();

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
                .map(entity -> new ProductDto(
                        entity.getProductId(),
                        entity.getName(),
                        entity.getDescription(),
                        entity.getPrice(),
                        //categoriesRepository.findById(entity.getCategory().getCategoryId()).orElse(null),
                        //new CategoryDto(), //????
                        entity.getCategory().getCategoryId(),
                        entity.getImageUrl(),
                        entity.getDiscountPrice()
                        ))
                .collect(Collectors.toList());
    }


    public ProductDto getProductById(Long id) { ///users/find/3
        return productDtoList.stream()
                .filter(product -> product.getProductId()==id)
                .findFirst()
                .orElse(null);
    }

    public ProductDto getProductByName(String name) { ///users/get?name=Other,k=2
        return productDtoList.stream()
                .filter(product -> product.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public boolean createProduct(ProductDto newProduct) { //insert
        return productDtoList.add(newProduct);
    }

    public ProductDto updateProduct(ProductDto updProduct) { //update
        ProductDto result = productDtoList.stream()
                .filter(product -> product.getProductId() == updProduct.getProductId())
                .findFirst()
                .orElse(null);
        if(result!=null) {
            result.setName(updProduct.getName());
        }
        return result;
    }

    public void deleteProduct(Long id) { //delete
        Iterator<ProductDto> it = productDtoList.iterator();
        while (it.hasNext()) {
            ProductDto current = it.next();
            if(current.getProductId()==id) {
                it.remove();
            }
        }
    }

    public void destroy() {
        productDtoList.clear();
        System.out.println("Run code after finishing work with the object: "
                + this.getClass().getName());
    }


}
