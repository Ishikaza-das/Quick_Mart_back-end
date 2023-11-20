package com.example.restapi.Controller;

import com.example.restapi.Model.Product;
import com.example.restapi.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/vendors/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Create Products
    @PostMapping("/api/vendors/products")
    public ResponseEntity<Product> saveProductDetails(@RequestBody Product product) {
        return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    // All Products
    @GetMapping("/api/vendors/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Get ModelId
    @GetMapping("/api/vendors/products/model/{modelid}")
    public ResponseEntity<Product> getProductsByModelId(@PathVariable("modelid") String productModel) {
        return new ResponseEntity<>(productService.getProductsByModelId(productModel), HttpStatus.FOUND);
    }

    // Get Id
    @GetMapping("/api/vendors/products/id/{id}")
    public ResponseEntity<Product> getProductsById(@PathVariable("id") long productId) {
        return new ResponseEntity<>(productService.getProductsById(productId), HttpStatus.FOUND);
    }

    // Update
    @PutMapping("/api/vendors/products/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
        return new ResponseEntity<Product>(productService.updateProduct(product, id), HttpStatus.OK);
    }

    // Delete
    @DeleteMapping("/api/vendors/products/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<String>("Product deleted successfully", HttpStatus.FORBIDDEN);
    }
}
