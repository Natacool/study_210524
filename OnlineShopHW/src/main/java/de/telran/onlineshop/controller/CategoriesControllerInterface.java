package de.telran.onlineshop.controller;

import de.telran.onlineshop.dto.CategoryDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@Tag(name = "Categories", description = "Контроллер для работы с категориями товаров",
        externalDocs = @ExternalDocumentation(
                description = "Ссылка на общую документацию по категориям",
                url = "https://example.com/docs/categories-controller"
        )
)
public interface CategoriesControllerInterface {
    @Operation(
            summary = "Все категории",
            description = "Позволяет получить все категории товаров"
    )
    List<CategoryDto> getAllCategories();

    @Operation(
            summary = "Поиск по Id",
            description = "Позволяет найти информация по идентификатору Id категории товара"
    )
    CategoryDto getCategoryById(
            @Parameter(description = "Идентификатор категории", required = true, example = "1")
            Long id) throws FileNotFoundException;


    @Operation(
            summary = "Search by Name",
            description = "This method searches information by product category's Name"
    )
    public CategoryDto getCategoryByName(@RequestParam String name);

    @Operation(
            summary = "Create a new Category",
            description = "This method creates a new Category"
    )
    public boolean createCategory(@RequestBody @Valid CategoryDto newCategory);

    @Operation(
            summary = "Update a Category",
            description = "This method updates an existing Category"
    )
    public CategoryDto updateCategory(@RequestBody @Valid CategoryDto updCategory);

    @Hidden //скрытие данного endpoint из openApi
    void deleteCategory(@PathVariable Long id);
}
