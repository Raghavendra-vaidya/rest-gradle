package com.rv.Testhelpers;

import com.google.gson.JsonObject;
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

}
