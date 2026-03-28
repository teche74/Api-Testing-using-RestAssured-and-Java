package com.rahulshettyacademy.tests;

import com.rahulshettyacademy.utils.BaseTest;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

public class getCartCountTest extends BaseTest {
    @Test(dependsOnGroups = "addToCart")
    public void getCartDetails(){
        response = RestAssured.given()
                .header("Authorization" , token)
                .when()
                .get("/api/ecom/user/get-cart-count/" + userId)
                .then()
                .statusCode(200)
                .extract()
                .response();


        response.prettyPrint();

        Assert.assertEquals(response.body().jsonPath().getInt("count"), productAddedCount);
        Assert.assertEquals(response.body().jsonPath().getString("message"), "Cart Data Found");
    }
}
