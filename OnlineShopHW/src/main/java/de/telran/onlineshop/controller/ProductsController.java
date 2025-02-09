package de.telran.onlineshop.controller;

import de.telran.onlineshop.dto.ProductDto;
import de.telran.onlineshop.service.ProductsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
@RequiredArgsConstructor
public class ProductsController implements ProductsControllerInterface {
    private final ProductsService productsService;
    //private List<ProductDto> productDtoList;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping  //select
    public List<ProductDto> getAllProducts() {
        return productsService.getAllProducts();
    }

    @GetMapping(value = "/find/{id}")
    public ProductDto getProductById(@PathVariable Long id) { ///users/find/3
        return productsService.getProductById(id);
    }

    // Экранирование кириллицы для url - https://planetcalc.ru/683/
    @GetMapping(value = "/get")
    public ProductDto getProductByName(@RequestParam String name) { ///users/get?name=Other,k=2
        return productsService.getProductByName(name);
    }

    @PostMapping //Jackson
    public boolean createProduct(@RequestBody @Valid ProductDto newProduct) { //insert
        return productsService.createProduct(newProduct);
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody @Valid ProductDto updProduct) { //update
        return productsService.updateProduct(updProduct);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable Long id) { //delete
        productsService.deleteProduct(id);
    }


    // For testing purpose
    @GetMapping(value = "/test")
    String productsGet(){
        return "Привет, я контроллер - ProductsController, " + this.toString();
    }
}
