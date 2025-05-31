package com.product.product.service;

import com.product.product.entity.Product;
import com.product.product.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

  private final ProductRepository repository;

  public ProductService(ProductRepository repository) {
    this.repository = repository;
  }

  public Product createProduct(Product product) {
    return repository.save(product);
  }

  public List<Product> getAllProducts() {
    return repository.findAll();
  }

  public ResponseEntity<?> getProductById(Long id) {
    Optional<Product> product = repository.findById(id);
    return product.map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  public ResponseEntity<?> updateProduct(Long id, Product updatedProduct) {
    return repository.findById(id).map(product -> {
      product.setName(updatedProduct.getName());
      product.setPrice(updatedProduct.getPrice());
      product.setQuantity(updatedProduct.getQuantity());
      return ResponseEntity.ok(repository.save(product));
    }).orElse(ResponseEntity.notFound().build());
  }

  public ResponseEntity<?> deleteProduct(Long id) {
    return repository.findById(id).map(product -> {
      repository.delete(product);
      return ResponseEntity.ok().build();
    }).orElse(ResponseEntity.notFound().build());
  }
}