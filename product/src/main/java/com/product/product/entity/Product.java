package com.product.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product name is required")
    @Size(min = 2, max = 100, message = "Product name must be between 2 and 100 characters.")
    @Column(nullable = false, length = 100)
    private String name;
    
    @NotNull(message = "Product price is required.")
    @DecimalMin(value = "0.01", message = "Price must be greater than zero")
    @Digits(integer=8, fraction=2, message = "Price format invalid (e.g., 12345678.99).")
    @Column(nullable = false, precision = 10, scale = 2)
    private double price;

    @NotNull(message = "Product quantity is required.")
    @Min(value = 1, message = "Quantity must be greater than zero")
    @Column(nullable = false)
    private int quantity;

    
}