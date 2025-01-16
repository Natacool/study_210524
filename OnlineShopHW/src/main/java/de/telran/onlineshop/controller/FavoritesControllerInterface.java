package de.telran.onlineshop.controller;

import de.telran.onlineshop.dto.FavoriteDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface FavoritesControllerInterface {

    @Operation(
            summary = "Get all Favorites",
            description = "This method gets all Favorites"
    )
    public List<FavoriteDto> getAllFavorites();

    @Operation(
            summary = "Get a Favorite by Id",
            description = "This method gets an existing Favorite by Id"
    )
    public FavoriteDto getProductById(Long id);

    @Operation(
            summary = "Create a new Favorite",
            description = "This method creates a new Favorite"
    )
    public boolean createProduct(FavoriteDto newFavorite);

    @Operation(
            summary = "Update a Favorite",
            description = "This method updates an existing Favorite"
    )
    public FavoriteDto updateFavorite(FavoriteDto updFavorite);

    @Operation(
            summary = "Delete a Favorite",
            description = "This method deletes an existing Favorite by Id"
    )
    public void deleteFavorite(Long id);

}
