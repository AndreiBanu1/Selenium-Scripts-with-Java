import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestParallel {

    @Test
    public void testCaseOne() {
        // Printing ID of the thread on using which test method got executed
        WebDriver driver = null;
        System.setProperty("webdriver.gecko.driver", "/Users/banuandreicristian/Documents/WebDrivers/geckodriver/geckodriver");

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("gttps://www.google.com");

        System.out.println(driver.getTitle());

        System.out.println("Test Case One with Thread Id: -" + Thread.currentThread().getId());
    }

    @Test
    public void testCaseTwo() {
        WebDriver driver = null;
        System.setProperty("webdriver.gecko.driver", "/Users/banuandreicristian/Documents/WebDrivers/geckodriver/geckodriver");

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("gttps://www.selenium.dev");

        System.out.println(driver.getTitle());

        System.out.println("Test Case Two with Thread Id: -" + Thread.currentThread().getId());
    }
}



