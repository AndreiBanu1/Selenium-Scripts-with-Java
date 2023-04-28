import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Set;

public class CallAndParseCookies {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/Users/banuandreicristian/Documents/WebDrivers/geckodriver/geckodriver");

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            driver.get("https://www.google.com");

            //Add a few cookies
            driver.manage().addCookie(new Cookie("test1", "cookie1"));
            driver.manage().addCookie(new Cookie("test2", "cookie2"));

            // Get specific cookie by name
            Cookie cookie1 = driver.manage().getCookieNamed("test1");
            //Get all available cookies
            Set<Cookie> cookies = driver.manage().getCookies();
            System.out.println(cookies);
        } finally {
            driver.quit();
        }
    }
}
