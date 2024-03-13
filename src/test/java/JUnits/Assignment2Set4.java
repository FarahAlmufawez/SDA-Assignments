package JUnits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Assignment2Set4 extends Tests{
    /*
Go to URL: http://demo.guru99.com/test/drag_drop.html
Drag and drop the BANK button to the Account section in DEBIT SIDE
Drag and drop the SALES button to the Account section in CREDIT SIDE
Drag and drop the 5000 button to the Amount section in DEBIT SIDE
Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
Verify the visibility of Perfect text.
*/
    @Test
    public void Assignment24(){
        bot.navigate("http://demo.guru99.com/test/drag_drop.html");
        Actions actions = new Actions(driver);
        // Drag and drop the BANK button to the Account section in DEBIT SIDE
        WebElement bankButton = driver.findElement(By.id("credit2"));
        WebElement debitSideAccount = driver.findElement(By.xpath("//ol[@id='bank']"));
        actions.dragAndDrop(bankButton, debitSideAccount).perform();

        // Drag and drop the SALES button to the Account section in CREDIT SIDE
        WebElement salesButton = driver.findElement(By.id("credit1"));
        WebElement creditSideAccount = driver.findElement(By.xpath("//ol[@id='loan']"));
        actions.dragAndDrop(salesButton, creditSideAccount).perform();

        // Drag and drop the 5000 button to the Amount section in DEBIT SIDE
        WebElement amount5000 = driver.findElement(By.xpath("(//li[@id='fourth'])[1]"));
        WebElement debitSideAmount5000 = driver.findElement(By.xpath("//ol[@id='amt7']"));
        actions.dragAndDrop(amount5000, debitSideAmount5000).perform();

        // Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
        WebElement secondAmount5000 = driver.findElement(By.xpath("(//li[@id='fourth'])[2]"));
        WebElement creditSideAmount5000 = driver.findElement(By.xpath("//ol[@id='amt8']"));
        actions.dragAndDrop(secondAmount5000, creditSideAmount5000).perform();

        // Verify the visibility of Perfect text     //a[@class='button button-green']
//        By perfectText = By.xpath("(//a[@class='button button-green'])[1]");
//        driver.findElement(perfectText).isDisplayed();
//        Assertions.assertEquals("Perfect!",perfectText);

        WebElement perfectText = driver.findElement(By.xpath("(//a[@class='button button-green'])[1]"));
        assert perfectText.isDisplayed();

    }
}
