package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Assignment4Set5 extends Tests {
    //Open the site: http://opencart.abstracta.us/index.php?route=account/login
//Login with that credentials
//Email: clarusway@gmail.com
//Password: 123456789
//Using the Search function do it with Data Provider for Mac, iPad and Samsung.

    //(create an array structure with "Mac, iPad and Samsung". You can see it in Assignment 2)
    @Test
    public void Register() {
        bot.navigate("http://opencart.abstracta.us/index.php?route=account/login");
        driver.findElement(By.xpath("//*[text()='Continue']")).click();
        // Find and fill the registration form
        WebElement firstNameField = driver.findElement(By.id("input-firstname"));
        WebElement lastNameField = driver.findElement(By.id("input-lastname"));
        WebElement emailField = driver.findElement(By.id("input-email"));
        WebElement telephoneField = driver.findElement(By.id("input-telephone"));
        WebElement passwordField = driver.findElement(By.id("input-password"));
        WebElement confirmPasswordField = driver.findElement(By.id("input-confirm"));
        WebElement agreeCheckbox = driver.findElement(By.name("agree"));

        firstNameField.sendKeys("John");
        lastNameField.sendKeys("Doe");
        emailField.sendKeys("example@example.com");
        telephoneField.sendKeys("1234567890");
        passwordField.sendKeys("password123");
        confirmPasswordField.sendKeys("password123");
        agreeCheckbox.click();

        // Click on the Register button
        WebElement registerButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        registerButton.click();
    }
    @Test(dependsOnMethods = "Register",dataProvider = "getData")
    public void Login( String keyword){
        // Find elements
        bot.navigate("https://opencart.abstracta.us/index.php?route=account/login");
        // Use search function with provided keyword
        WebElement searchInput = driver.findElement(By.name("search"));
        WebElement searchButton = driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));

        searchInput.sendKeys(keyword);
        searchButton.click();

    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {"Mac"},
                {"iPad"},
                {"Samsung"}
        };
    }


}

