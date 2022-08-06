package com.rv.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTest {

    @Test(description = "user test" )
    public void createUser(){
        Assert.assertTrue(true);
    }

    @Test(description = "get user", groups ={"defect"})
    public void getUser(){
        Assert.assertTrue(false);
    }
}
