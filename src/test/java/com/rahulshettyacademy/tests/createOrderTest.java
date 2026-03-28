package com.rahulshettyacademy.tests;

import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.rahulshettyacademy.utils.BaseTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class createOrderTest extends BaseTest{
    @Test(dependsOnGroups = {"getCartDetails"} , groups = "createOrder")
    public void createOrderTest() {

        List<Map<String, String>> ordersList = new ArrayList<>();

        for (String productId : UserCartProductsId) {
            Map<String, String> orderMap = new HashMap<>();
            orderMap.put("country", "India");
            orderMap.put("productOrderedId", productId);

            ordersList.add(orderMap);
        }

        Map<String, Object> finalPayload = new HashMap<>();
        finalPayload.put("orders", ordersList);

        response = RestAssured.given()
                .header("Authorization", token)
                .contentType("application/json")
                .body(finalPayload)
                .when()
                .post("/api/ecom/order/create-order")
                .then()
                .extract()
                .response();

        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(), 201);

        String message = response.jsonPath().getString("message");
        Assert.assertEquals(message, "Order Placed Successfully");

        orderIds.clear();
        orderIds.addAll(response.jsonPath().getList("orders"));
    }
}
