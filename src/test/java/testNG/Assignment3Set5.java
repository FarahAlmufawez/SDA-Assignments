package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assignment3Set5 extends Tests{
//    private static final Logger logger = LogManager.getLogger(LoginTestWithLogging.class);

    /* Add three different log messages for the task below:
go to "https://practicetestautomation.com/practice-test-login/"
enter username - "student"
enter password - "incorrectPassword"
and login
SOFT ASSERT the error message shown
SOFT ASSERT the error message is "Your password is invalid!" */
    @Test
    public void logger(){
        bot.navigate("https://practicetestautomation.com/practice-test-login/");
        logger.info("Opened URL: https://practicetestautomation.com/practice-test-login/");

        // Find elements
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("submit"));
        // Enter username and password
        usernameField.sendKeys("student");
        logger.info("Entered username: student");
        passwordField.sendKeys("incorrectPassword");
        logger.info("Entered password: incorrectPassword");
        // Click login button
        loginButton.click();
        logger.info("Clicked on login button");
        // Soft assert the error message
        SoftAssert softAssert = new SoftAssert();
        WebElement errorMessage = driver.findElement(By.id("error"));
        softAssert.assertEquals(errorMessage.getText(), "Your password is invalid!");
        logger.info("Soft assert the error message");
        // Assert all soft assertions
        softAssert.assertAll();



    }

}
