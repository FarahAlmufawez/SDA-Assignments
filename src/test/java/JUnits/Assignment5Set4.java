package JUnits;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

public class Assignment5Set4 extends Tests{
    /*   Go to URL: http://facebook.com
        getCookies,
        addCookie,
        deleteCookieNamed,
        deleteAllCookies
     */
    @Test
    public void Assignment54(){
        bot.navigate(" http://facebook.com");
        //1.getCookies
        System.out.println("All Cookies : " + driver.manage().getCookies());

        //2.addCookie
        driver.manage().addCookie(new Cookie("fruit","apple"));
        // Get all cookies after adding a new one
        System.out.println("All Cookies After Adding: " + driver.manage().getCookies());

        //3.deleteCookieNamed
        driver.manage().deleteCookieNamed("fruit");
        // Get all cookies after deleting the fruit
        System.out.println("All Cookies After Deleting Named Cookie: " + driver.manage().getCookies());

        //4.deleteAllCookies
        driver.manage().deleteAllCookies();
        // Get all cookies after deleting all cookies
        System.out.println("All Cookies After Deleting All: " + driver.manage().getCookies());

    }
}
