package com.example.stocks.dto;

import lombok.Data;
@Data

public class ProductDto {

    public int productId;

    public String productName;

    public String productDescription;

    public int productAmount;

    public int categoryId;
}
