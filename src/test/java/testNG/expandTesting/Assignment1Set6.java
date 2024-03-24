package testNG.expandTesting;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.expandTesting.Registration;
import testNG.Tests;

public class Assignment1Set6 extends Tests {
/*
            go to url : https://ecommerce-playground.lambdatest.io/index.php?route=account/register
            register account test with fluent page object approach
         */

    @Test(description = "Successful Registration")
    public void FluentRegisteration(){
        String actualText = new Registration(driver,bot)
                .goTo()
                .successfulLogin((String) testCaseData.get("fname"),
                        (String) testCaseData.get("lname"),
                        (String) testCaseData.get("email"),
                        (String) testCaseData.get("telphone"),
                        (String) testCaseData.get("password"),
                        (String) testCaseData.get("confirmpass"))
                .readSuccessMessage();
        Assert.assertEquals(actualText, (String) testCaseData.get("ExpectedSuccessMessage"));
        logger.info("Registration was successful as expected!");
    }


    @BeforeClass
    public void initializeTestDataReader(){
        testCaseData = (JSONObject) testData.get("expandTesting");
    }
}
