package JUnits;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Assignment4Set4 extends Tests{
    @Test
    public void Assignment44() throws AWTException, InterruptedException {
            /*
       Go to Amazon
       Scroll to the bottom of the page using a robot
       Click on the "Back to top" web element
       Click on the Amazon logo at the bottom of the page (in the footer) using JavascriptExecutor
       Use Actions to type "ClarusWay" in the search box and perform the search
    */
        //1.Go to Amazon
        bot.navigate("https://www.amazon.com/stores/page/CDF3296F-98B9-4A3E-BCA2-4834A6E96166");
        //2.Scroll to the bottom of the page using a robot
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_END);
        robot.keyRelease(KeyEvent.VK_END);
        Thread.sleep(2000);
        //3.Click on the "Back to top" web element
        wait.until(f -> {
       driver.findElement(By.id("navBackToTop")).click();
            return true;
        });


        //4.Click on the Amazon logo at the bottom of the page (in the footer) using JavascriptExecutor
         JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
         WebElement amazonLogo = driver.findElement(By.xpath("//a[@href='/?ref_=footer_logo']"));
         jsExecutor.executeScript("arguments[0].click();", amazonLogo);

        //5.Use Actions to type "ClarusWay" in the search box and perform the search
        Actions actions = new Actions(driver);
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        actions.sendKeys(searchBox, "ClarusWay").sendKeys(Keys.RETURN).perform();

        // Add a short sleep to visually see the search results
        Thread.sleep(2000);
    }
    }

