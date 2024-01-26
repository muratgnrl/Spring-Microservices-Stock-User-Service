package com.example.stocks.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Kategori_anahtarı",updatable = false, unique = true)
    private int categoryId;

    @Column(name = "Kategori_adı",unique = true ,nullable = false)
    private String categoryName;

    @Column(name = "Kategori_açıklaması",nullable = false)
    private String categoryDescription;


    @OneToMany(mappedBy = "category")
    private List<Product>productList;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Category(int categoryId, String categoryName, String categoryDescription, List<Product> productList) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.productList = productList;
    }

    public Category() {
    }
}
