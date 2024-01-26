package com.example.stocks.dto;

import com.example.stocks.entity.Product;
import lombok.Data;


import java.io.Serializable;
import java.util.List;
@Data
public class CategoryDto implements Serializable {

    public int categoryId;

    public String categoryName;


    public String categoryDescription;


    public List<ProductDto> productList;
}
