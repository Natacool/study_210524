package de.telran.onlineshop.controller;

import de.telran.onlineshop.dto.ProductDto;
import de.telran.onlineshop.service.CategoriesService;
import de.telran.onlineshop.service.ProductsService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
@RequiredArgsConstructor
public class ProductsController {
    private final ProductsService productsService;
    private List<ProductDto> productDtoList;
    @GetMapping(value = "/test")
    String productsGet(){

        return "Привет, я контроллер - ProductsController, " + this.toString();
    }

/*
    @GetMapping  //select
    List<ProductDto> getAllCategories() {
        return productDtoList;
    }
*/
    @ResponseStatus(HttpStatus.OK)
    @GetMapping  //select
    public List<ProductDto> getAllProducts() {
        return productsService.getAllProducts();
    }

    @GetMapping(value = "/find/{id}")
    ProductDto getProductById(@PathVariable Long id) { ///users/find/3
        return productDtoList.stream()
                .filter(product -> product.getProductId()==id)
                .findFirst()
                .orElse(null);
    }

    // Экранирование кириллицы для url - https://planetcalc.ru/683/
    @GetMapping(value = "/get")
    ProductDto getProductByName(@RequestParam String name) { ///users/get?name=Other,k=2
        return productDtoList.stream()
                .filter(product -> product.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @PostMapping //Jackson
    public boolean createProducts(@RequestBody ProductDto newProduct) { //insert
        return productDtoList.add(newProduct);
    }

    @PutMapping
    public ProductDto updateProducts(@RequestBody ProductDto updProduct) { //update
        ProductDto result = productDtoList.stream()
                .filter(product -> product.getProductId() == updProduct.getProductId())
                .findFirst()
                .orElse(null);
        if(result!=null) {
            result.setName(updProduct.getName());
        }
        return result;
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProducts(@PathVariable Long id) { //delete
        Iterator<ProductDto> it = productDtoList.iterator();
        while (it.hasNext()) {
            ProductDto current = it.next();
            if(current.getProductId()==id) {
                it.remove();
            }
        }
    }

    @PreDestroy
    void destroy() {
        productDtoList.clear();
        System.out.println("Run code after finishing work with the object: "
                + this.getClass().getName());
    }

}
