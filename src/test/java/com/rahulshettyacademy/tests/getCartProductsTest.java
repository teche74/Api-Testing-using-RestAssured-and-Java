package com.rahulshettyacademy.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rahulshettyacademy.utils.BaseTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class getCartProductsTest extends BaseTest {
    @Test(groups = "getCartDetails", dependsOnGroups = { "addToCart" })
    public void getCartProducts() {
        response = RestAssured.given()
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/ecom/user/get-cart-products/" + userId)
                .then()
                .extract()
                .response();

        response.prettyPrint();

        List<String> productIds = response.jsonPath().getList("products._id");
        UserCartProductsId.clear();
        UserCartProductsId.addAll(productIds);
        Assert.assertTrue(UserCartProductsId.containsAll(productIds));
    }
}
