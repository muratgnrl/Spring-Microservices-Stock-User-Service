package com.example.stocks.service;

import com.example.stocks.dto.ProductDto;
import com.example.stocks.entity.Category;
import com.example.stocks.entity.Product;
import com.example.stocks.exception.productBaseException.AddProductException;
import com.example.stocks.exception.productBaseException.DeleteProductException;
import com.example.stocks.exception.productBaseException.FindProductException;
import com.example.stocks.mapper.ProductMapper;
import com.example.stocks.repository.ProductRepository;
import com.example.stocks.response.Meta;
import com.example.stocks.response.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryService categoryService;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.categoryService = categoryService;
    }


    public ProductResponse addProduct(ProductDto productDto) throws AddProductException {
        Product product=productMapper.toEntity(productDto);
        Category category=categoryService.findCategoryByDto(productDto.categoryId);
        product.setCategory(category);
        product=productRepository.save(product);
        if (product!=null){
            ProductResponse productResponse=new ProductResponse();
            productResponse.productDto=productMapper.toResource(product);
            productResponse.meta=new Meta(200,"ÜRÜN EKLENDİ" );
            return productResponse;
        }
        throw new AddProductException();
    }

    public ProductResponse delete(int productId) throws DeleteProductException {
        Optional<Product> product=productRepository.findById(productId);
        if (product.isPresent()){
            productRepository.deleteById(productId);
            ProductResponse productResponse=new ProductResponse();
            productResponse.meta=new Meta(200,"Ürün Silindi.");
            return productResponse;
        }
        throw new DeleteProductException();
    }

    public ProductResponse findProductByDto(int productId) throws FindProductException {
       Product product = findProduct(productId);
        if (product!=null){
            ProductResponse productResponse=new ProductResponse();
            productResponse.meta=new Meta(200,"Ürün bulundu");
            productResponse.productDto=productMapper.toResource(product);
            return productResponse;
        }
        throw new FindProductException();
    }

    private Product findProduct(int productId) {
        Product product=productRepository.findProductByProductId(productId);
        return product;
    }


}
