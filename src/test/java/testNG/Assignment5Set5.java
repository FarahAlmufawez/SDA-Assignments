package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Assignment5Set5 extends Tests {
    //Go to URL: http://crossbrowsertesting.github.io/
    //Click to To-Do App
    //Checking Box to do-4 and Checking Box to do-5
    //If both clicks worked, then the following List should be have length 2.
    //Assert that this is correct
    //Assert that the to do we added is present in the list
    //Archiving old todos
    //If our archive link worked, then the following list should have length 4.
    //Assert that this is true as well
    //Doing Cross Browser Testing.
    @Test
    public void toDoListTest() {
        bot.navigate("http://crossbrowsertesting.github.io/");

        // Click to To-Do App
        WebElement todoAppLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("To-Do App")));
        todoAppLink.click();

        // Check To-Do 4 and To-Do 5 checkboxes
        WebElement todoFourCheckbox = driver.findElement(By.name("todo-4"));
        todoFourCheckbox.click();

        WebElement todoFiveCheckbox = driver.findElement(By.name("todo-5"));
        todoFiveCheckbox.click();

        // If both clicks worked, then the following List should be have length 2
        List elems = driver.findElements(By.className("done-true"));
        // So we'll assert that this is correct.
        Assert.assertEquals(2, elems.size());

        driver.findElement(By.id("todotext")).sendKeys("Run your first Selenium Test");
        driver.findElement(By.id("addbutton")).click();

        // Let's also assert that the todo we added is present in the list.
        WebElement spanText = driver.findElement(By.xpath("(//span[@class='done-false'])[4]"));
        Assert.assertEquals(spanText.getText(),"Run your first Selenium Test");
        driver.findElement(By.linkText("archive")).click();

        // If our archive link worked, then the following list should have length 4.
        elems = driver.findElements(By.className("done-false"));
        //  assert that this is true as well.
       Assert.assertEquals(4, elems.size());

    }
}
