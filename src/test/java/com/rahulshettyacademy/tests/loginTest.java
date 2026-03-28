package com.rahulshettyacademy.tests;

import com.rahulshettyacademy.utils.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class loginTest extends BaseTest {

    @Test(groups = "login")
    public void loginTest() {

        response = RestAssured.given()
                .contentType("application/json")
                .body("""
                   {
                        "userEmail" : "testapi54@gmail.com",
                        "userPassword":"!3niuFE!6ZN9KAb"
                   }
                   """)
                .when()
                .post("/api/ecom/auth/login")
                .then()
                .extract()
                .response();

        response.prettyPrint();

        Assert.assertEquals(response.statusCode(), 200);

        String message = response.jsonPath().getString("message");
        Assert.assertEquals(message, "Login Successfully");

        token = response.jsonPath().getString("token");
        userId = response.jsonPath().getString("userId");

        System.out.println("Token: " + token);
        System.out.println("User ID: " + userId);
    }
}
