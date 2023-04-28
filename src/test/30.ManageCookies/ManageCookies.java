import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;

public class Example {
    public static void main(String[] args) {
        String driverPath = "/Users/banuandreicristian/Documents/WebDrivers/geckodriver/geckodriver";
        String url = "http://www.google.com";

        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();

        //Add cookies
        driver.manage().addCookie(new Cookie("test1", "cookie1"));
        driver.manage().addCookie(new Cookie("test2", "cookie2"));

        // print all cookies
        Set<Cookie> allCookies = driver.manage().getCookies();
        for (Cookie cookie : allCookies) {
            System.out.println(cookie.getName() + " : " + cookie.getValue());
        }

        //Delete just one Cookie by name
        driver.manage().deleteCookieNamed("test1");

        //Delete all cookies
        driver.manage().deleteAllCookies();
        System.out.println(driver.manage().getCookies());

        driver.quit();
    }
}
