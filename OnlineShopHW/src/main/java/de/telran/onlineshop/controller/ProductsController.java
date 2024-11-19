package de.telran.onlineshop.controller;

import de.telran.onlineshop.model.Product;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductsController {
    private List<Product> productList;
    @GetMapping(value = "/test")
    String productsGet(){

        return "Привет, я контроллер - ProductsController, " + this.toString();
    }


    @PostConstruct
    void init() {
        productList = new ArrayList<>();

        productList.add(new Product(1, "Product1", "Description of product1", 123.45F, 1, "", null));
        productList.add(new Product(2, "Product2", "Description of product2", 456.01F, 1, "", null));
        productList.add(new Product(3, "Product3", "Description of product3", 234.23F, 2, "", null));
        productList.add(new Product(4, "Product4", "Description of product4", 123.45F, 3, "", null));
        productList.add(new Product(5, "Product5", "Description of product5", 234.23F, 2, "", null));

        System.out.println("Run code during creating an object: "
                + this.getClass().getName());
    }

    @GetMapping  //select
    List<Product> getAllCategories() {
        return productList;
    }

    @GetMapping(value = "/find/{id}")
    Product getProductById(@PathVariable Long id) { ///users/find/3
        return productList.stream()
                .filter(product -> product.getProductId()==id)
                .findFirst()
                .orElse(null);
    }

    // Экранирование кириллицы для url - https://planetcalc.ru/683/
    @GetMapping(value = "/get")
    Product getProductByName(@RequestParam String name) { ///users/get?name=Other,k=2
        return productList.stream()
                .filter(product -> product.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @PostMapping //Jackson
    public boolean createProducts(@RequestBody Product newProduct) { //insert
        return productList.add(newProduct);
    }

    @PutMapping
    public Product updateProducts(@RequestBody Product updProduct) { //update
        Product result = productList.stream()
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
        Iterator<Product> it = productList.iterator();
        while (it.hasNext()) {
            Product current = it.next();
            if(current.getProductId()==id) {
                it.remove();
            }
        }
    }

    @PreDestroy
    void destroy() {
        productList.clear();
        System.out.println("Run code after finishing work with the object: "
                + this.getClass().getName());
    }

}
