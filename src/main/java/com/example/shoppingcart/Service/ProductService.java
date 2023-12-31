package com.example.shoppingcart.Service;

import com.example.shoppingcart.Model.Product;

import java.util.List;

public interface ProductService {
//    Save
    Product saveProduct(Product product);
//    Get
    List<Product> getAllProducts();
//    Get Model ID
    Product getProductsByModelId(String ProductModel);
//    Get By ID
    Product getProductsById(Long ID);
//    Update
    Product updateProduct (Product product, long id);
//    Delete
    void deleteProduct(long id);
}
