package com.rahulshettyacademy.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;

import java.util.*;

public class BaseTest {
    protected static String token;
    protected static String userId;
    protected static Response response;
    protected static Integer productAddedCount = 0;
    protected static HashSet<String> UserCartProductsId = new HashSet<>();
    protected static List<String> orderIds = new ArrayList<>();

    protected static HashMap<String , Map<String, Object>> AllProductDetails = new HashMap<>();

    public static HashMap<String, Object> buildProductBody(
            String userId,
            Map<String, Object> product
    ) {
        HashMap<String, Object> body = new HashMap<>();
        body.put("_id", userId);
        body.put("product", product);

        return body;
    }

    @BeforeClass
    public void setupBaseURL(){
        RestAssured.baseURI = "https://rahulshettyacademy.com/";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
