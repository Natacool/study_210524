package de.telran.onlineshop.controller;

import de.telran.onlineshop.dto.CategoryDto;
import de.telran.onlineshop.entity.CategoriesEntity;
import de.telran.onlineshop.repository.CategoriesRepository;
import de.telran.onlineshop.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
//@RequiredArgsConstructor
public class CategoriesController {
    // final - for @RequiredArgsConstructor
    //@Autowired - иньекция через value (не рекомендуемая из-за Reflection)
    private CategoriesService categoriesService;

    @GetMapping
    String categoriesGet(){
        return "Привет, я контроллер - CategoriesController, " + this.toString();
    }

    // test tmp - failed security, we should never get repo entities to end user
/*
    @Autowired
    private CategoriesRepository categoriesRepository;
    @GetMapping(value = "/all")
    public List<CategoriesEntity> getAllCategoriesEntity() {
        return categoriesRepository.findAll();
    }
*/

    //@Autowired - иньекция через конструктор (рекомендуемая !!!), авто аннотирование с версии 3.0
    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    // @Autowired - иньекция через сеттер (обязательно использовать аннотацию)
    public void setCategoryService(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping  //select
    public List<CategoryDto> getAllCategories() {
        return categoriesService.getAllCategories();
    }

    @GetMapping(value = "/find/{id}")
    public CategoryDto getCategoryById(@PathVariable Long id) { ///categories/find/3
        return categoriesService.getCategoryById(id);
    }

    // Экранирование кириллицы для url - https://planetcalc.ru/683/
    @GetMapping(value = "/get")
    public CategoryDto getCategoryByName(@RequestParam String name) { ///categories/get?name=Other,k=2
        return categoriesService.getCategoryByName(name);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping //Jackson
    public boolean createCategories(@RequestBody CategoryDto newCategory) { //insert
        return categoriesService.createCategories(newCategory);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping
    public CategoryDto updateCategories(@RequestBody CategoryDto updCategory) { //update
        return categoriesService.updateCategories(updCategory);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCategories(@PathVariable Long id) { //delete
        categoriesService.deleteCategories(id);
    }

    // альтернативная обработка ошибочной ситуации Exception
    @ExceptionHandler({IllegalArgumentException.class, FileNotFoundException.class})
    public ResponseEntity handleTwoException(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    }

    // альтернативная обработка ошибочной ситуации Exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.I_AM_A_TEAPOT)
                .body("Извините, что-то пошло не так. Попробуйте позже!");
    }



}
