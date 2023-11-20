package com.example.restapi.Service.Impl;


import com.example.restapi.Exception.ResourceNotFound;
import com.example.restapi.Model.Product;
import com.example.restapi.Repository.ProductRepository;
import com.example.restapi.Service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
//      Create/Save
    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
//     Show
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
//    Get ModelID
    @Override
    public Product getProductsByModelId(String productModel) {
        Optional<Product> productOptional = Optional.ofNullable(productRepository.findByProductModel(productModel));
        if (productOptional.isPresent()) {
            return productOptional.get();
        } else {
            throw new ResourceNotFound("Products", "Product_Model", productModel);
        }
    }
//    Get ID
    @Override
    public Product getProductsById(Long ID) {
        Optional<Product> optionalProduct = productRepository.findById(ID);
        if (optionalProduct.isPresent()){
            return optionalProduct.get();
        }else {
            throw new ResourceNotFound("Products", "ID", ID);
        }
    }
//    Update
    @Override
    public Product updateProduct(Product product, long id) {
        Product exproduct = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Products", "ID", id)
        );
        exproduct.setProductName(product.getProductName());
        exproduct.setProductCategory(product.getProductCategory());
        exproduct.setProductModel(product.getProductModel());
        exproduct.setProductQuantity(product.getProductQuantity());
        exproduct.setProductPrice(product.getProductPrice());

        productRepository.save(exproduct);
        return exproduct;
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Products", "ID", id)
        );
        productRepository.deleteById(id);
    }

}
