package com.example.shoppingcart.Repository;

import com.example.shoppingcart.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByProductModel(String productModel);
}

