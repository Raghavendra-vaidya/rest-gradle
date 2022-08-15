package com.rkv.endPoints;

import com.rkv.utility.Configuration;
import io.restassured.RestAssured;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;

public class Users {
    static Configuration config = new Configuration();

    public static Response createUser(String body, int statusCode) {
        RestAssured.baseURI = config.base_uri;
        String endPoint = RestAssured.baseURI + config.user_ep;
        Response response =
                given()
                        .log().ifValidationFails()
                        .header("Content-Type", "application/json")
                        .accept("*/*")
                        .body(body)
                .when()
                        .post(endPoint)
                .then()
                        .assertThat().statusCode(statusCode).extract().response();

        return response;
    }

    public static Response getUserByUsername(String username, int statusCode){
        RestAssured.baseURI = config.base_uri;
        String endpoint = RestAssured.baseURI+config.user_ep+"/"+username;

        Response response =
                given()
                        .log().ifValidationFails()
                        .header("Content-Type","application/json")
                .when()
                        .get(endpoint)
                .then()
                        .assertThat().statusCode(statusCode).extract().response();

        return response;
    }
    public static Response deleteUserByUsername(String username, int statusCode){
        RestAssured.baseURI = config.base_uri;
        String endpoint = RestAssured.baseURI+config.user_ep+"/"+username;

        Response response =
                given()
                        .log().ifValidationFails()
                        .header("Content-Type","application/json")
                .when()
                        .delete(endpoint)
                .then()
                        .assertThat().statusCode(statusCode).extract().response();

        return response;
    }
}
