package com.rv.Testhelpers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.rkv.utility.JsonUtils;

import java.util.Calendar;

public class Helpers {

    public static String formSampleCreatePetReqBody(){
        JsonObject reqObj = JsonUtils.getJsonFileAsJsonObject("src/test/resources/AddNewPet.json");

        String name = "Kitty"+ Calendar.getInstance().getTimeInMillis();
        String id = String.valueOf(Calendar.getInstance().getTimeInMillis());
        String status = "available";

        reqObj.addProperty("id",id);
        reqObj.addProperty("name",name);
        reqObj.addProperty("status",status);
        return reqObj.toString();
    }
    public static String formSampleCreateUserReqBody(){
        JsonObject reqObj = JsonUtils.getJsonFileAsJsonObject("src/test/resources/createUser.json");

        String name = "Hardy"+ Calendar.getInstance().getTimeInMillis();
        reqObj.addProperty("username",name);
        reqObj.addProperty("firstName",name);
        reqObj.addProperty("lastName","jigg");
        reqObj.addProperty("email",name+"@test.com");
        reqObj.addProperty("password","pass");
        return reqObj.toString();
    }

    public static JsonObject sampleUserReqBodyObject(){
        JsonObject reqObj = JsonUtils.getJsonFileAsJsonObject("src/test/resources/createUser.json");

        String name= "Hardy"+Calendar.getInstance().getTimeInMillis();
        reqObj.addProperty("username",name);
        reqObj.addProperty("firstName",name);
        reqObj.addProperty("lastName","jigg");
        reqObj.addProperty("email",name+"@test.com");
        reqObj.addProperty("password","pass");
        return reqObj;
    }



}
