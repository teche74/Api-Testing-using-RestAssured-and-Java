# 📘 API Testing using RestAssured and Java
---

## 🚀 Overview

This project demonstrates **end-to-end API automation testing** using **Java, RestAssured, and TestNG**. It covers real-world e-commerce scenarios such as authentication, cart operations, order creation, and deletion.

The framework showcases:

* API chaining
* Dynamic payload generation
* Response validation
* TestNG-based execution control

---

## 🧰 Tech Stack

* **Java**
* **RestAssured**
* **TestNG**
* **Maven**
* **JSON (JsonPath parsing)**

---

## 📂 Project Structure

```
src
 └── test
      └── java
           └── com.rahulshettyacademy
                ├── tests
                │     ├── loginTest.java
                │     ├── getAllProductsTest.java
                │     ├── productsAddedtoCartTest.java
                │     ├── getCartProductsTest.java
                │     ├── CreateOrderTest.java
                │     └── deleteOrdersTest.java
                │
                └── utils
                      └── BaseTest.java

testng.xml
pom.xml
```

---

## 🔄 Test Flow (End-to-End)

1. 🔐 Login → Generate authentication token
2. 📦 Fetch all products
3. ➕ Add products to cart
4. 🛒 Fetch cart products
5. 🧾 Create order using cart product IDs
6. ❌ Delete created orders

---

## ⚙️ Key Features

### ✅ API Chaining

Data is passed between APIs:

* `productId → orderId`

---

### ✅ Dynamic Payload Creation

```java
for (String productId : UserCartProductsId) {
    Map<String, String> orderMap = new HashMap<>();
    orderMap.put("country", "India");
    orderMap.put("productOrderedId", productId);
}
```

---

### ✅ Response Validation

* Status code validation
* Message validation
* Data integrity checks

```java
Assert.assertEquals(message, "Order Placed Successfully");
```

---

### ✅ Reusable Base Class

Centralized setup for:

* Base URI
* Authentication token
* Shared response handling

---

### ✅ TestNG Execution Control

* `dependsOnGroups`
* `dependsOnMethods`
* Ordered execution via `testng.xml`

---

## ▶️ How to Run

### 1️⃣ Clone Repository

```
git clone https://github.com/teche74/Api-Testing-using-RestAssured-and-Java.git
```

---

### 2️⃣ Install Dependencies

```
mvn clean install
```

---

### 3️⃣ Run Tests

```
mvn test
```

Or run directly via:

```
testng.xml
```

---

## 🧪 Sample Test (Create Order)

```java
response = RestAssured.given()
        .header("Authorization", token)
        .contentType("application/json")
        .body(finalPayload)
        .when()
        .post("/api/ecom/order/create-order")
        .then()
        .extract()
        .response();
```

---

## 📊 Assertions Covered

* ✔ Status Code Validation
* ✔ Response Body Validation
* ✔ JSON Path Extraction
* ✔ Data Matching (Cart → Order)

---

## 👨‍💻 Author

**Ujjwal Bisht**

---

## ⭐ Final Note

This project demonstrates the transition from:

❌ Static API testing
➡️
✅ Dynamic, chained API automation framework

---
