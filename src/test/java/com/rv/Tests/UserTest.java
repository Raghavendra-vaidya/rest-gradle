package com.rv.Tests;

import com.google.gson.JsonObject;
import com.rkv.endPoints.Users;
import com.rv.Testhelpers.Helpers;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTest {

    @Test(description = "Create user and verify" )
    public void createUser(){
       String reqBody =  Helpers.formSampleCreateUserReqBody();
       Response apiResponse = Users.createUser(reqBody, 200);
       String message = apiResponse.jsonPath().get("message").toString();
       Assert.assertFalse(message.isEmpty());
    }

    @Test(description = "get user by id and verify")
    public void getUser(){
        JsonObject reqBody =  Helpers.sampleUserReqBodyObject();
        String username1 = reqBody.get("username").toString();
        String username = username1.replace("\"","");

        Response apiResponse = Users.createUser(reqBody.toString(), 200);

        Response getResponse = Users.getUserByUsername(username, 200);
        String userNameActual = getResponse.jsonPath().get("username").toString();
        Assert.assertEquals(userNameActual,username);
    }

    @Test(description = "delete user and verify", groups ={"defect"})
    public void deleteUser(){
        Assert.assertTrue(false);
    }
}
