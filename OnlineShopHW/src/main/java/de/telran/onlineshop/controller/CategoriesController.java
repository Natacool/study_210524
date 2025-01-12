package de.telran.onlineshop.controller;

import de.telran.onlineshop.dto.CategoryDto;
import de.telran.onlineshop.service.CategoriesService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
@Slf4j
//@RequiredArgsConstructor
public class CategoriesController {
    // final - for @RequiredArgsConstructor
    //@Autowired - инъекция через value (не рекомендуемая из-за Reflection)
    private CategoriesService categoriesService;

    // test tmp - failed security, we should never get repo entities to end user

    //@Autowired - инъекция через конструктор (рекомендуемая !!!), авто аннотирование с версии 3.0
    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    // @Autowired - инъекция через сеттер (обязательно использовать аннотацию)
    public void setCategoryService(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping  //select
    public List<CategoryDto> getAllCategories() {
        long start = System.currentTimeMillis();
        List<CategoryDto> result = categoriesService.getAllCategories();
        log.info("getAllCategories:" + (System.currentTimeMillis() - start));
        return categoriesService.getAllCategories();
    }

    @GetMapping(value = "/find/{id}")
    public CategoryDto getCategoryById(@PathVariable Long id) { ///categories/find/3  // throws FileNotFoundException
// for testing - artificial situation
//        if (id < 0) {
//            new IllegalArgumentException("id should NOT be negative");
//        }

        return categoriesService.getCategoryById(id);
    }

    // Экранирование кириллицы для url - https://planetcalc.ru/683/
    @GetMapping(value = "/get")
    public CategoryDto getCategoryByName(@RequestParam String name) { ///categories/get?name=Other,k=2
        return categoriesService.getCategoryByName(name);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping //Jackson
    public boolean createCategory(@RequestBody @Valid CategoryDto newCategory) { //insert
        return categoriesService.createCategory(newCategory);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping
    public CategoryDto updateCategory(@RequestBody @Valid CategoryDto updCategory) { //update
        return categoriesService.updateCategory(updCategory);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCategory(@PathVariable Long id) { //delete
        categoriesService.deleteCategory(id);
    }

    // альтернативная обработка ошибочной ситуации Exception
    @ExceptionHandler({IllegalArgumentException.class, FileNotFoundException.class})
    public ResponseEntity handleTwoException(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT) //HttpStatus.BAD_REQUEST
                .body("CategoriesController: " + exception.getMessage());
    }

/*/
    // альтернативная обработка ошибочной ситуации Exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.I_AM_A_TEAPOT)
                .body("Извините, что-то пошло не так. Попробуйте позже!" + exception.getMessage());
    }
*/


    // For testing purpose
    @GetMapping(value = "/test")
    String categoriesGet(){
        return "Привет, я контроллер - CategoriesController, " + this.toString();
    }


}
