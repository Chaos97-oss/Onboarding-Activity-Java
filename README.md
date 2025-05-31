# Product Management API

## Overview
This is a RESTful API built with Spring Boot for managing products. It supports typical CRUD operations: create, read, update, and delete products. The API is designed for easy integration into your applications and provides secure access to product data.

## Base URL
http://localhost:8081/products
## Authentication
Currently, this API does not require authentication. (You can update this if you add JWT or other auth later.)

## Endpoints

### 1. GET /products
Retrieve a list of all products.

- **URL:** `http://localhost:8081/products'
- **Method:** GET
- **Response:**
```json
[
  {
    "id": 1,
    "name": "Laptop",
    "description": "A powerful laptop",
    "price": 999.99,
    "stock": 10
  },
]

### 2. GET /products
Retrieve a list of all products.

- **URL:** `/api/v1/products`
- **Method:** GET
- **Response:**
```json{
  "id": 1,
  "name": "Laptop",
  "description": "A powerful laptop",
  "price": 999.99,
  "stock": 10
}


