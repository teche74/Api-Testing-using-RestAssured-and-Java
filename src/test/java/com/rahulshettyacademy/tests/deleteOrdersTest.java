package com.rahulshettyacademy.tests;

import com.rahulshettyacademy.utils.BaseTest;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

public class deleteOrdersTest extends BaseTest {

    @Test(dependsOnGroups = "createOrder")
    public void deleteOrders() {

        for (String orderId : orderIds) {

            response = RestAssured.given()
                    .header("Authorization", token)
                    .when()
                    .delete("/api/ecom/order/delete-order/" + orderId)
                    .then()
                    .extract()
                    .response();

            System.out.println("Deleted Order ID: " + orderId);
            System.out.println(response.asPrettyString());

            Assert.assertTrue(response.getStatusCode() == 200 || response.getStatusCode() == 204);
        }
    }
}