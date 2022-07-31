package com.rkv.endPoints;

import com.rkv.utility.Configuration;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;

public class Pets {
    static Configuration config = new Configuration();

    public static Response addPet(String body, int statusCode) {
        RestAssured.baseURI = config.base_uri;
        String endPoint = RestAssured.baseURI + config.pets_ep;
        Response response =
                given()
                        .log().ifValidationFails()
                        .header("Content-Type", "application/json")
                        .body(body)
                .when()
                        .post(endPoint)
                .then()
                        .assertThat().statusCode(statusCode).extract().response();

        return response;
    }

    public static Response updatePet(String body, int statusCode) {
        RestAssured.baseURI = config.base_uri;
        String endPoint = RestAssured.baseURI + config.pets_ep;
        Response response =
                given()
                        .log().ifValidationFails()
                        .header("Content-Type","application/json")
                        .accept("*/*")
                        .body(body)
                .when()
                        .put(endPoint)
                .then()
                        .assertThat().statusCode(statusCode).extract().response();

        return response;
    }

    public static Response uploadPetImage(int petID,String filePath, int statusCode) {
        RestAssured.baseURI = config.base_uri;
        String endPoint = RestAssured.baseURI +config.pets_ep+"/"+petID+config.pets_image_ep;
        Response response =
                given()
                        .log().ifValidationFails()
                        .header("Content-Type","multipart/form-data")
                        .accept("*/*")
                        .multiPart("file",new File(filePath))
                .when()
                        .post(endPoint)
                .then()
                        .assertThat().statusCode(statusCode).extract().response();

        return response;
    }

    public static Response findPetByStatus(String petStatus, int statusCode){
        RestAssured.baseURI = config.base_uri;
        String endPoint = RestAssured.baseURI+config.findByStatus;
        Response response =
                given()
                        .log().ifValidationFails()
                        .header("Content-Type","application/json")
                        .accept("*/*")
                        .queryParam("status",petStatus)
                .when()
                        .get(endPoint)
                .then()
                        .assertThat().statusCode(statusCode).extract().response();

        return response;
    }

    public static Response getPetById(String petID, int statusCode){
        RestAssured.baseURI = config.base_uri;
        String endpoint = RestAssured.baseURI+config.pets_ep+"/"+petID;

        Response response =
                given()
                        .log().ifValidationFails()
                        .header("Content-Type","application/json")
                        .accept("*/*")
                .when()
                        .get(endpoint)
                .then()
                        .assertThat().statusCode(statusCode).extract().response();

        return response;
    }

    public static Response deletePetById(String petID, int statusCode){
        RestAssured.baseURI = config.base_uri;
        String endpoint = RestAssured.baseURI+config.pets_ep+"/"+petID;

        Response response =
                given()
                        .log().ifValidationFails()
                        .header("Content-Type","application/json")
                        .accept("*/*")
                .when()
                        .delete(endpoint)
                .then()
                        .assertThat().statusCode(statusCode).extract().response();

        return response;
    }
}
