package com.product.product.controller;

import com.product.product.entity.Product;
import com.product.product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping("/create-produc")
  public ResponseEntity<?> createProduct(@Valid @RequestBody Product product) {
    return ResponseEntity.ok(productService.createProduct(product));
  }

  @GetMapping("/get-all-product")
  public List<Product> getAllProducts() {
    return productService.getAllProducts();
  }

  @GetMapping("/get-product-by-id/{id}")
  public ResponseEntity<?> getProduct(@PathVariable Long id) {
    return productService.getProductById(id);
  }

  @PutMapping("/update-product/{id}")
  public ResponseEntity<?> updateProduct(@PathVariable Long id, @Valid @RequestBody Product product) {
    return productService.updateProduct(id, product);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
    return productService.deleteProduct(id);
  }
} 