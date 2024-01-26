package com.example.stocks.repository;

import com.example.stocks.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findProductByProductId(int productId);
}
