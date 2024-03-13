package testNG;

import org.testng.annotations.Test;

public class Assignment1Set5 extends Tests{
     /*
    Create tests that depend on each other
    Create beforeClass and set up settings.
    By creating interdependent tests;
    First go to Facebook.
    Then go to Google depending on Facebook,
    Then go to Amazon depending on Google
    Close the driver.
     */
     @Test
     public void testFacebook() {
         // Open Facebook
         bot.navigate("https://www.facebook.com");
     }

    @Test(dependsOnMethods = "testFacebook")
    public void testGoogle() {
        // Open Google after Facebook
        bot.navigate("https://www.google.com");
    }

    @Test(dependsOnMethods = "testGoogle")
    public void testAmazon() {
        // Open Amazon after Google
        bot.navigate("https://www.amazon.com");
    }

}
