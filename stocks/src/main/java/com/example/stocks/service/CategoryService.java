package com.example.stocks.service;

import com.example.stocks.dto.CategoryDto;
import com.example.stocks.entity.Category;
import com.example.stocks.exception.categoryBaseResponse.CreateCategoryException;
import com.example.stocks.exception.categoryBaseResponse.DeleteCategoryException;
import com.example.stocks.exception.categoryBaseResponse.FindCategoryException;
import com.example.stocks.mapper.CategoryMapper;
import com.example.stocks.repository.CategoryRepository;
import com.example.stocks.response.CategoryResponse;
import com.example.stocks.response.Meta;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {


    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public CategoryResponse addCategory(CategoryDto categoryDto) throws CreateCategoryException {

        Category category = categoryMapper.toEntity(categoryDto);
        category = categoryRepository.save(category);
        if (category != null) {
            CategoryResponse response = new CategoryResponse();
            response.meta = new Meta(200, "Başarılı");
            response.categoryDto = categoryMapper.toResource(category);
            return response;
        }
            throw new CreateCategoryException();
        }





    public CategoryResponse deleteCategory(int categoryId) throws DeleteCategoryException {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if (categoryOptional.isPresent()) {
            categoryRepository.deleteById(categoryId);
            CategoryResponse categoryResponse = new CategoryResponse();
            categoryResponse.meta = new Meta(200, "Silindi  : " + categoryId);
            return categoryResponse;
        } else {
            throw new DeleteCategoryException();
        }

    }

    public CategoryResponse findCategory(int categoryId)throws FindCategoryException{
        Category category = findCategoryByDto(categoryId);
        if (category !=null) {
            CategoryResponse categoryResponse=new CategoryResponse();
            categoryResponse.categoryDto=categoryMapper.toResource(category);
            categoryResponse.meta=new Meta(200,"Obje bulundu");
            return categoryResponse;

        }
           throw new FindCategoryException();
        }

    public Category findCategoryByDto(int categoryId) {
        Category category=categoryRepository.findCategoryByCategoryId(categoryId);
        return category;
    }



}
