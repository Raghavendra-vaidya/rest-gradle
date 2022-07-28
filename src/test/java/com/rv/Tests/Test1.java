package com.rv.Tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Test1 {

    @BeforeClass
    public void setUPUrl(){
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath ="/v2/pet/";
    }
    @Test
    public void a1(){
        Assert.assertTrue(true);
    }

    @Test
    public void a2(){
        String endPoint = "https://petstore.swagger.io/v2/pet/findByStatus?status=available";
        String ep = RestAssured.baseURI+RestAssured.basePath+"findByStatus?status=available";

        Response response = given().log().ifValidationFails()
                .header("accept","application/json")
                .when()
                    .get("findByStatus?status=available")
                .then().
                    assertThat().statusCode(200).extract().response();

        JsonPath api = response.jsonPath();
        System.out.println(response.body().asString());
        System.out.println(RestAssured.baseURI);
        System.out.println(ep);
    }
}
