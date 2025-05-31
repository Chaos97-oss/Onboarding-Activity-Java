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
    "price": 999.99,
    "quantity": 10
  },
]
```
2. GET /products/{id}
Retrieve a product by its ID.

URL: http://localhost:8081/products/(id)
Method: GET
Response:
```json
{
  "id": 1,
  "name": "Laptop",
  "price": 999.99,
  "quantity": 10
}
```
3. POST /products
Create a new product.

URL: http://localhost:8081/products/create-product
Method: POST
Headers: Content-Type: application/json
Body:
```
{
  "name": "Smartphone",
  "price": 699.99,
  "quantity": 25
}
```
Resoponse
```json
{
  "id": 2,
  "name": "Smartphone",
  "description": "Latest model smartphone",
  "price": 699.99,
  "stock": 25
}
```
4. PUT /products/{id}
Update an existing product.

URL: http://localhost:8081/products/create-product
Method: PUT
Headers: Content-Type: application/json
Body:
```json
{
  "name": "Smartphone Pro",
  "price": 799.99,
  "quantity": 20
}
```
Response
```json
{
  "id": 2,
  "name": "Smartphone Pro",
  "description": "Updated model smartphone",
  "price": 799.99,
  "stock": 20
}
```
5. DELETE /products/{id}
Delete a product by its ID.

URL: http://localhost:8081/products/create-product
Method: DELETE
Response:
```json
{
  "message": "Product deleted successfully"
}
```
Error Handling

The API returns standard HTTP status codes to indicate success or failure of requests:

200 OK - Successful GET, PUT, DELETE requests
201 Created - Successful POST request
400 Bad Request - Validation error or malformed request
404 Not Found - Requested product not found
500 Internal Server Error - Server error
Response body on errors will include a message describing the issue.

How to Run Locally

Clone the repo
Run the Spring Boot app:
```bash
mvn spring-boot:run
```
The server will start on port 8081.
Use Postman or curl to test endpoints at http://localhost:8081/api/v1/products.

Postman Documentation

Interactive API documentation is available on Postman:
https://documenter.getpostman.com/view/43208616/2sB2qgdyPD



Contact

For questions, contact Paul Udegbue at udegbuepaul43@gmail.com.








