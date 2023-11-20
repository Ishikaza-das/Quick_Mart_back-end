package com.example.restapi.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Product_Name", nullable = false, length = 50)
    private String productName;

    @Column(name = "Product_Model", nullable = false, length = 50)
    private String productModel;

    @Column(name = "Product_Quantity", nullable = false, length = 50)
    private Integer productQuantity;

    @Column(name = "Product_Category", nullable = false, length = 50)
    private String productCategory;

    @Column(name = "Product_Price", nullable = false, length = 50)
    private Integer productPrice;

}
