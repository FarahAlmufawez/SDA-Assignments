package JUnits;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class Assignment6Set4 extends Tests{
    // Go to amazon.com
    // Take Full Page Screenshot.
    // Take any spesific WebElement ScreenShot
    @Test
    public void Assignment64() throws InterruptedException, IOException {
        bot.navigate("https://www.amazon.com/stores/page/CDF3296F-98B9-4A3E-BCA2-4834A6E96166");
        //1.Take Full Page Screenshot
        File fullPageScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        saveScreenshot(fullPageScreenshot, "fullPageScreenshot.png");

        //2.Take any spesific WebElement ScreenShot
        WebElement amazonLogo = driver.findElement(By.id("nav-logo"));
        File elementScreenshot = takeElementScreenshot(amazonLogo);
        saveScreenshot(elementScreenshot, "amazonLogoScreenshot.png");
    }

    private void saveScreenshot(File screenshotFile, String fileName) throws IOException {
        FileHandler.copy(screenshotFile, new File(fileName));
    }

    private File takeElementScreenshot(WebElement element) throws WebDriverException {
        return element.getScreenshotAs(OutputType.FILE);
    }

}


