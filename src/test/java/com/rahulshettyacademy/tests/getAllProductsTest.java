package com.rahulshettyacademy.tests;

import com.rahulshettyacademy.utils.BaseTest;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class getAllProductsTest extends BaseTest{

//    @Test (dependsOnMethods = "com.rahulshettyacademy.tests.loginTest.loginTest")
    @Test(groups = "product", dependsOnGroups = "login")
    public void getAllProducts(){
        response = RestAssured.given()
                .header("Authorization",  token)
                .body(
                        """
                                {"productName":"","minPrice":null,"maxPrice":null,"productCategory":[],"productSubCategory":[],"productFor":[]}     
                           """
                )
                .when()
                .post("/api/ecom/product/get-all-products")
                .then()
                .extract()
                .response();

        response.prettyPrint();


        Assert.assertEquals(response.getStatusCode(), 200);

        List<Map<String, Object>> products = response.jsonPath().getList("data");

        for(Map<String, Object> product : products){
            AllProductDetails.put(product.get("productName").toString() , product);
        }
    }



}
