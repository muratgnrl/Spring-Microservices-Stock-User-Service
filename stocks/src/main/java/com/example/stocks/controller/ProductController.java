package com.example.stocks.controller;

import com.example.stocks.dto.ProductDto;
import com.example.stocks.exception.productBaseException.AddProductException;
import com.example.stocks.exception.productBaseException.DeleteProductException;
import com.example.stocks.exception.productBaseException.FindProductException;
import com.example.stocks.response.ProductResponse;
import com.example.stocks.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/addProduct")
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductDto productDto) throws AddProductException {
        return ResponseEntity.ok(productService.addProduct(productDto));
    }
    @DeleteMapping("/delete/{productId}")
    public ProductResponse deleteProduct(@PathVariable (value = "productId") int productId) throws DeleteProductException {
        return productService.delete(productId);
    }
    @GetMapping("/find/{productId}")
    public ProductResponse findProductByDto(@PathVariable ("productId") int productId) throws FindProductException {
        return productService.findProductByDto(productId);
    }
}
