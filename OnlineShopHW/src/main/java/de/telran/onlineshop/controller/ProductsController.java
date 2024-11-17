package de.telran.onlineshop.controller;

import de.telran.onlineshop.model.Products;
import de.telran.onlineshop.model.RolesEnum;
import de.telran.onlineshop.model.Users;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductsController {
    private List<Products> productsList;
    @GetMapping(value = "/test")
    String productsGet(){

        return "Привет, я контроллер - ProductsController, " + this.toString();
    }


    @PostConstruct
    void init() {
        productsList = new ArrayList<>();

        productsList.add(new Products(1, "Product1", "Description of product1", 123.45F, 1, "", null));
        productsList.add(new Products(2, "Product2", "Description of product2", 456.01F, 1, "", null));
        productsList.add(new Products(3, "Product3", "Description of product3", 234.23F, 2, "", null));
        productsList.add(new Products(4, "Product4", "Description of product4", 123.45F, 3, "", null));
        productsList.add(new Products(5, "Product5", "Description of product5", 234.23F, 2, "", null));

        System.out.println("Run code during creating an object: "
                + this.getClass().getName());
    }

    @GetMapping  //select
    List<Products> getAllCategories() {
        return productsList;
    }

    @GetMapping(value = "/find/{id}")
    Products getProductById(@PathVariable Long id) { ///users/find/3
        return productsList.stream()
                .filter(product -> product.getProductId()==id)
                .findFirst()
                .orElse(null);
    }

    // Экранирование кириллицы для url - https://planetcalc.ru/683/
    @GetMapping(value = "/get")
    Products getProductByName(@RequestParam String name) { ///users/get?name=Other,k=2
        return productsList.stream()
                .filter(product -> product.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @PostMapping //Jackson
    public boolean createProducts(@RequestBody Products newProduct) { //insert
        return productsList.add(newProduct);
    }

    @PutMapping
    public Products updateProducts(@RequestBody Products updProduct) { //update
        Products result = productsList.stream()
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
        Iterator<Products> it = productsList.iterator();
        while (it.hasNext()) {
            Products current = it.next();
            if(current.getProductId()==id) {
                it.remove();
            }
        }
    }

    @PreDestroy
    void destroy() {
        productsList.clear();
        System.out.println("Run code after finishing work with the object: "
                + this.getClass().getName());
    }

}
