package testNG;



import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*/
 //Go to URL: https://opensource-demo.orangehrmlive.com/
    //Login with negative credentilas by Data Provider.
    //Then assert that ‘’Invalid credentials’’ is displayed.
    //Run it parallel with 3 threads
    //Generate Allure report


  @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {"admin*","admin123"},
                {"admin12","123"},
                {"Admin1","***00**"},
                {"test","123"},
                {"user","369"},
		}
        };
 */
public class Assignment2Set5 extends Tests {



    @Test(dataProvider = "getData", threadPoolSize = 3)
    public void LoginTest(String username, String password) throws InterruptedException {
        bot.navigate("https://opensource-demo.orangehrmlive.com/");
        bot.type(By.name("username"), username);
        bot.type(By.name("password"), password);
        bot.click(By.tagName("button"));

        Thread.sleep(1000);

        String actualErrorMessage = driver.findElement(By.xpath("//*[.='Invalid credentials']")).getText();
        Assert.assertEquals(actualErrorMessage, "Invalid credentials");

    }
    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {"admin*", "admin123"},
                {"admin12", "123"},
                {"Admin1", "***00**"},
                {"test", "123"},
                {"user", "369"},
        };
    }
}