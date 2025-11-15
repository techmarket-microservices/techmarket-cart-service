# TechMarket Cart Service

This microservice handles the shopping cart functionality for the TechMarket e-commerce platform.

---

## **Overview**

The Cart Service allows customers to manage their shopping carts, including:

- Adding products to cart
- Updating quantities
- Removing products
- Retrieving cart contents

---

## **Features**

- **CRUD operations** for cart items
- **User-specific carts** identified by `userId`
- Integration with **Redis** 
- Designed for microservice architecture

---

## **Tech Stack**

- Java 21
- Spring Boot 3.5.7
- Spring Data JPA
- PostgreSQL
- Redis
- Maven

---

## **API Endpoints**

All endpoints are prefixed with `/api/cart`.

| Endpoint             | Method | Description                                      |
|----------------------|--------|--------------------------------------------------|
| `/api/cart`          | POST   | Add a product to the cart or update the quantity |
| `/api/cart/{userId}` | DELETE | Remove product from cart                         |
| `/api/cart/{userId}` | GET    | Get all cart items for a user                    |

**Example: Add to Cart Request**

```json
POST /api/cart
{
  "userId": "user123",
  "productId": "prod456",
  "quantity": 2
}
