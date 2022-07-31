package com.rv.Tests;

import com.rkv.endPoints.Pets;
import com.rv.Testhelpers.Helpers;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PetTests {

    @Test(description = "create new pet and verify")
    public void createNewPet(){
        String requestBody = Helpers.formSampleCreatePetReqBody();
        Response apiResponse = Pets.addPet(requestBody, 200);
        String Astatus = apiResponse.jsonPath().get("status").toString();

        Assert.assertFalse(apiResponse.jsonPath().get("id").toString().isEmpty());
        Assert.assertEquals(Astatus, "available");
    }

}
