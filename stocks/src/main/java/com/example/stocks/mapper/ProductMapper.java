package com.example.stocks.mapper;

import com.example.stocks.dto.ProductDto;
import com.example.stocks.entity.Product;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ProductMapper extends EntityMapper<ProductDto, Product>{
}
