package com.rv.Tests;

import com.rkv.endPoints.Pets;
import com.rv.Testhelpers.Helpers;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PetTests {

    @Test(description = "create new pet and verify")
    public void createNewPet(){
        String requestBody = Helpers.formSampleCreatePetReqBody();
        Response apiResponse = Pets.addPet(requestBody, 200);
        String Astatus = apiResponse.jsonPath().get("status").toString();

        Assert.assertFalse(apiResponse.jsonPath().get("id").toString().isEmpty());
        Assert.assertEquals(Astatus, "available");
    }

    @Test(description = "find pet by status available")
    public void findPetByStatusAvailable(){
        String status = "available";
        Response apiResponse = Pets.findPetByStatus(status,200);
        List<String> listOfStatus=  apiResponse.jsonPath().get("status");
        boolean isAvailable = true;
        for (String s: listOfStatus) {
            if (s.equalsIgnoreCase("available")){
                continue;
            }
            else {
                isAvailable = false;
                break;
            }
        }
        Assert.assertTrue(isAvailable, "All the pets are not of status available in api response");
    }
    @Test(description = "find pet by status pending")
    public void findPetByStatusPending(){
        String status = "pending";
        Response apiResponse = Pets.findPetByStatus(status,200);
        List<String> listOfStatus=  apiResponse.jsonPath().get("status");

        boolean isAvailable = true;
        for (String s: listOfStatus) {
            if (s.equalsIgnoreCase("pending")){
                continue;
            }
            else {
                isAvailable = false;
                break;
            }
        }
        Assert.assertTrue(isAvailable, "All the pets are not of status pending in api response");
    }

    @Test(description = "find pet by status sold")
    public void findPetByStatusSold(){
        String status = "sold";
        Response apiResponse = Pets.findPetByStatus(status,200);
        List<String> listOfStatus=  apiResponse.jsonPath().get("status");

        boolean isAvailable = true;
        for (String s: listOfStatus) {
            if (s.equalsIgnoreCase("sold")){
                continue;
            }
            else {
                isAvailable = false;
                break;
            }
        }
        Assert.assertTrue(isAvailable, "All the pets are not of status pending in api response");
    }
    @Test(description = "get pet by id and verify")
    public void getPetByID(){
        String requestBody = Helpers.formSampleCreatePetReqBody();
        Response apiResponse = Pets.addPet(requestBody, 200);
        String petID = apiResponse.jsonPath().get("id").toString();
        Response response = Pets.getPetById(petID,200);
        Assert.assertEquals(response.jsonPath().get("id").toString(), petID);
    }

    @Test(description = "delete created pet and verify")
    public void deleteNewPet(){
        String requestBody = Helpers.formSampleCreatePetReqBody();
        Response apiResponse = Pets.addPet(requestBody, 200);
        String petId = apiResponse.jsonPath().get("id").toString();

        Pets.deletePetById(petId, 200);
    }



    @Test(description = "This excluded", groups = {"defect"})
    public void boomTest(){
        Assert.assertTrue(true);
    }
}
