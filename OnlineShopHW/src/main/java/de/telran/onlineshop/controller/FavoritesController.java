package de.telran.onlineshop.controller;

import de.telran.onlineshop.dto.FavoriteDto;
import de.telran.onlineshop.dto.OrderDto;
import de.telran.onlineshop.service.CartItemsService;
import de.telran.onlineshop.service.FavoritesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/favorites")
@RequiredArgsConstructor
public class FavoritesController {
    private final FavoritesService favoritesService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping  //select
    public List<FavoriteDto> getAllFavorites() {
        return favoritesService.getAllFavorites();
    }

    @GetMapping(value = "/find/{id}")
    public FavoriteDto getProductById(@PathVariable Long id) { ///users/find/3
        return favoritesService.getFavoriteById(id);
    }

    @PostMapping //Jackson
    public boolean createProduct(@RequestBody @Valid FavoriteDto newFavorite) { //insert
        return favoritesService.createFavorite(newFavorite);
    }

    @PutMapping
    public FavoriteDto updateFavorite(@RequestBody @Valid FavoriteDto updFavorite) { //update
        return favoritesService.updateFavorite(updFavorite);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteFavorite(@PathVariable Long id) { //delete
        favoritesService.deleteFavorite(id);
    }


    // For testing purpose
    @GetMapping(value = "/test")
    String favoritesGet(){
        return "Привет, я контроллер - FavoritesController, " + this.toString();
    }

}
