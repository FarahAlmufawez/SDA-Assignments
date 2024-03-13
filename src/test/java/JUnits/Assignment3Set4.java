package JUnits;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class Assignment3Set4 extends Tests {
    // go to https://www.google.com/
// search for "Scroll Methods" by using an Actions object
    @Test
    public void Assignment34(){
        bot.navigate("https://www.google.com/");
        Actions actions= new Actions(driver);
        //use the actions and while holding the SHIFT key type "s" and then continue to type "croll" then click space
        actions.keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("croll")
                // Click space
                .sendKeys(Keys.SPACE)
                // Hold SHIFT, make "m" capital, and continue typing "ethods"
                .keyDown(Keys.SHIFT)
                .sendKeys("m")
                .keyUp(Keys.SHIFT)
                .sendKeys("ethods")
                // Click Enter
                .sendKeys(Keys.ENTER)
                .perform();


    }
}
