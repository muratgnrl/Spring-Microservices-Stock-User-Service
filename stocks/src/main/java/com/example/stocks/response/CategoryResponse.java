package com.example.stocks.response;

import com.example.stocks.dto.CategoryDto;

import java.io.Serializable;

public class CategoryResponse extends BaseResponse implements Serializable {
    public CategoryDto categoryDto;
}
