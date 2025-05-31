package com.product.product.controller;

import com.product.product.entity.Product;
import com.product.product.service.ProductService;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.product.product.dto.ApiResponse;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping("/create-produc")
  public ResponseEntity<ApiResponse<Product>> createProduct(@Valid @RequestBody Product product) {
    try {
        Product createdProduct = productService.createProduct(product);
        ApiResponse<Product> response = new ApiResponse<>(201, "Product created successfully", createdProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    } catch (Exception e) {
        ApiResponse<Product> response = new ApiResponse<>(500, "Error creating product", null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}

  @GetMapping("/get-all-product")
 public ResponseEntity<ApiResponse<List<Product>>> getAllProducts() {
    try {
        List<Product> products = productService.getAllProducts();
        ApiResponse<List<Product>> response = new ApiResponse<>(200,"All products retrieved successfully",products);
        return ResponseEntity.ok(response); 
    } catch (Exception e) {
        ApiResponse<List<Product>> errorResponse = new ApiResponse<>(500,"Error retrieving products: " + e.getMessage(),null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}

 @GetMapping("/get-product-by-id/{id}")
public ResponseEntity<ApiResponse<Product>> getProduct(@PathVariable Long id) {
    try {
        Product product = productService.getProductById(id);
        ApiResponse<Product> response = new ApiResponse<>(200, "Product retrieved successfully", product);
        return ResponseEntity.ok(response);
    } catch (RuntimeException e) {
        ApiResponse<Product> errorResponse = new ApiResponse<>(404,"Product not found: " + e.getMessage(), null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}

@PutMapping("/update-product/{id}")
public ResponseEntity<ApiResponse<Product>> updateProduct(
        @PathVariable Long id,
        @Valid @RequestBody Product product
) {
    try {
        Product updatedProduct = productService.updateProduct(id, product);
        ApiResponse<Product> response = new ApiResponse<>(200, "Product updated successfully",
                updatedProduct);
        return ResponseEntity.ok(response);
    } catch (RuntimeException e) {
        ApiResponse<Product> errorResponse = new ApiResponse<>( 404,"Product not found: " + e.getMessage(),
        null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    } catch (Exception e) {
        ApiResponse<Product> errorResponse = new ApiResponse<>(500,"Error updating product: " + e.getMessage(),
        null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}

@DeleteMapping("/delete/{id}")
public ResponseEntity<ApiResponse<String>> deleteProduct(@PathVariable Long id) {
    try {
        productService.deleteProductById(id);
        ApiResponse<String> response = new ApiResponse<>(200, "Product deleted successfully",
          null );
        return ResponseEntity.ok(response);
    } catch (RuntimeException e) {
        ApiResponse<String> errorResponse = new ApiResponse<>(404,"Product not found: " + e.getMessage(),null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
}