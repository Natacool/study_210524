package de.telran.onlineshop.controller;

import de.telran.onlineshop.dto.ProductDto;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

public interface ProductsControllerInterface {

    @Operation(
            summary = "All Products",
            description = "This method gets all Products"
    )
    public List<ProductDto> getAllProducts();

    @Operation(
            summary = "Search by Id",
            description = "This method searches a Product by Id"
    )
    public ProductDto getProductById(Long id);

    @Operation(
            summary = "Search by Name",
            description = "This method searches information by product's Name"
    )
    public ProductDto getProductByName(String name);

    @Operation(
            summary = "Create a new Product",
            description = "This method creates a new Product"
    )
    public boolean createProduct(ProductDto newProduct);

    @Operation(
            summary = "Update a Product",
            description = "This method updates an existing Product"
    )
    public ProductDto updateProduct(ProductDto updProduct);

    @Operation(
            summary = "Delete a Product",
            description = "This method deletes an existing Product by Id"
    )
    public void deleteProduct(Long id);

}
