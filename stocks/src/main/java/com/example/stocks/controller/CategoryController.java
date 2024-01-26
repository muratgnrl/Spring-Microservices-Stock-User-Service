package com.example.stocks.controller;

import com.example.stocks.dto.CategoryDto;
import com.example.stocks.exception.categoryBaseResponse.CreateCategoryException;
import com.example.stocks.exception.categoryBaseResponse.DeleteCategoryException;
import com.example.stocks.exception.categoryBaseResponse.FindCategoryException;
import com.example.stocks.response.CategoryResponse;
import com.example.stocks.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping("/addCategory")
    public ResponseEntity<CategoryResponse> addCategory(@RequestBody CategoryDto categoryDto) throws CreateCategoryException {
        return ResponseEntity.ok(service.addCategory(categoryDto));
    }

    @GetMapping("/find/{categoryId}")
    public CategoryResponse findCategory(@PathVariable("categoryId") int categoryId) throws FindCategoryException {
        return service.findCategory(categoryId);
    }
    @DeleteMapping("/delete/{categoryId}")
    public CategoryResponse deleteCategory(@PathVariable("categoryId") int categoryId) throws DeleteCategoryException {
        return service.deleteCategory(categoryId);
    }

}
