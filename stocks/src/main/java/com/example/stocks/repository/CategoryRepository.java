package com.example.stocks.repository;

import com.example.stocks.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    Category findCategoryByCategoryId(int categoryId);
}
