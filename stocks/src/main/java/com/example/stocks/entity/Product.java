package com.example.stocks.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    @Column(name = "Ürün_adı")
    private String productName;

    @Column(name = "Ürün_açıklaması")
    private String productDescription;

    @Column(name = "Ürün_fiyatı")
    private int productAmount;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;


}
