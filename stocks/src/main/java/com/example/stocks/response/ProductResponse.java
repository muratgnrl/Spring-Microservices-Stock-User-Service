package com.example.stocks.response;

import com.example.stocks.dto.ProductDto;

import java.io.Serializable;

public class ProductResponse extends BaseResponse implements Serializable {
    public ProductDto productDto;
}
