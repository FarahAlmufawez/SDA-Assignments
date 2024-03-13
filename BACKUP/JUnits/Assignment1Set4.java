package JUnits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Set;

public class Assignment1Set4 extends Tests {
    //Go to URL: https://the-internet.herokuapp.com/windows
    //Verify the text: “Opening a new window”
    //Verify the title of the page is “The Internet”
    //Click on the “Click Here” button
    //Verify the new window title is “New Window”
    //Go back to the previous window and then verify the title: “The Internet”
    @Test
    public void Assignment14(){
        //1.Go to URL: https://the-internet.herokuapp.com/windows
        bot.navigate("https://the-internet.herokuapp.com/windows");

        //2.Verify the text: “Opening a new window”
        String openingWindowText = driver.findElement(By.tagName("h3")).getText();
        Assertions.assertEquals("Opening a new window", openingWindowText);

        // 3.Verify the title of the page is “The Internet”
        String originalWindowTitle = driver.getTitle();
        Assertions.assertEquals("The Internet", originalWindowTitle);

        // 4.Click on the “Click Here” button
        By ClickHereLink = By.linkText("Click Here");
        bot.click(ClickHereLink);

        //5.Verify the new window title is “New Window”
        var originalWindowHandel = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        handles.remove(originalWindowHandel);
        String newWindowHandel = (String) handles.toArray()[0];
        driver.switchTo().window(newWindowHandel);

        //6.Verify the new window title is “New Window”
        String newWindowTitle =  driver.findElement(By.tagName("h3")).getText();
        Assertions.assertEquals("New Window", newWindowTitle);

        //7.Go back to the previous window
        driver.switchTo().window(originalWindowHandel);

        // Verify the title: “The Internet” in the original window
        String backToOriginalWindowTitle = driver.getTitle();
        Assertions.assertEquals("The Internet", backToOriginalWindowTitle);

    }
}
