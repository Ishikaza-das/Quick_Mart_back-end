package com.example.shoppingcart.controller;

import com.example.shoppingcart.Model.Product;
import com.example.shoppingcart.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//    Create Products
    @PostMapping("/api/products")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
            return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
        }

//    @PostMapping("/api/products")
//    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
//        // Ensure ProductCategory is set before saving
//        if (product.getProductCategory() == null || product.getProductCategory().isEmpty()) {
//            // Handle the case where ProductCategory is required
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
//    }

//    All Products
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
//    Get ModelId
    @GetMapping("/model/{modelid}")
    public ResponseEntity<Product> getProductsByModelId(@PathVariable("modelid") String productModel){
        return new ResponseEntity<>(productService.getProductsByModelId(productModel), HttpStatus.FOUND);
    }
//    Get Id
    @GetMapping("/id/{id}")
    public ResponseEntity<Product> getProductsById(@PathVariable("id") long productId){
        return new ResponseEntity<>(productService.getProductsById(productId), HttpStatus.FOUND);
    }
//    Update
    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id")long id,@RequestBody Product product){
        return new ResponseEntity<Product>(productService.updateProduct(product,id),HttpStatus.OK);
    }
//    Delete
    @DeleteMapping("{id}")
    public ResponseEntity<String > deleteProduct(@PathVariable("id")long id){
        productService.deleteProduct(id);
        return new ResponseEntity<String>("Product deleted successfully",HttpStatus.FORBIDDEN);
    }

}


