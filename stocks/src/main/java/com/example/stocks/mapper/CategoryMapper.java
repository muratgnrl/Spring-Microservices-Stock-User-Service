package com.example.stocks.mapper;

import com.example.stocks.dto.CategoryDto;
import com.example.stocks.entity.Category;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CategoryMapper extends EntityMapper<CategoryDto, Category>{

}
