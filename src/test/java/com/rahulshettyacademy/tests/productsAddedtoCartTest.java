package com.rahulshettyacademy.tests;

import com.rahulshettyacademy.utils.BaseTest;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class productsAddedtoCartTest extends BaseTest {

//    @Test(dependsOnMethods = "com.rahulshettyacademy.tests.getAllProductsTest.getAllProducts" , groups = "addToCart")
    @Test(groups = "addToCart", dependsOnGroups = "product")
    public void addAdidasOriginalToCart() {

        Map<String, Object> product = AllProductDetails.get("ADIDAS ORIGINAL");

        response = RestAssured.given()
                .header("Authorization", token)
                .contentType("application/json")
                .body(buildProductBody(userId, product))
                .when()
                .post("/api/ecom/user/add-to-cart")
                .then()
                .statusCode(200).extract().response();


        Assert.assertEquals(response.body().jsonPath().getString("message"), "Product Added To Cart");
        productAddedCount++;
    }

//    @Test (dependsOnMethods = "com.rahulshettyacademy.tests.getAllProductsTest.getAllProducts" , groups = "addToCart")
    @Test(groups = "addToCart", dependsOnGroups = "product")
    public void addZaraCoatToCart(){
        Map<String, Object> product = AllProductDetails.get("ZARA COAT 3");
        response = RestAssured.given()
                .header("Authorization", token)
                .contentType("application/json")
                .body(buildProductBody(userId, product))
                .when()
                .post("/api/ecom/user/add-to-cart")
                .then()
                .statusCode(200).extract().response();

        response.prettyPrint();


        Assert.assertEquals(response.body().jsonPath().getString("message"), "Product Added To Cart");
        productAddedCount++;
    }


//    @Test (dependsOnMethods = "com.rahulshettyacademy.tests.getAllProductsTest.getAllProducts" , groups = "addToCart")
    @Test(groups = "addToCart", dependsOnGroups = "product")
    public void addIphone13ToCart(){
        Map<String, Object> product = AllProductDetails.get("iphone 13 pro");
        response = RestAssured.given()
                .header("Authorization", token)
                .contentType("application/json")
                .body(buildProductBody(userId, product))
                .when()
                .post("/api/ecom/user/add-to-cart")
                .then()
                .statusCode(200).extract().response();


        Assert.assertEquals(response.body().jsonPath().getString("message"), "Product Added To Cart");
        productAddedCount++;
    }

}