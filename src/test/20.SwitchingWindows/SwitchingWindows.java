import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SwitchingWindows {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/Users/banuandreicristian/Documents/WebDrivers/geckodriver/geckodriver");

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        driver.get("https://localhost:5000/easytesting");

        String ParentWindow = driver.getWindowHandle();
        driver.findElement(By.id("btnk")).click();
        Set<String> winHandles = driver.getWindowHandles();
        for (String handle : winHandles) {
            if (!handle.equals((ParentWindow))) {
                // New Window Section
                driver.switchTo().window(handle);
                Thread.sleep(1000);
                System.out.println("Title of the new window: " + driver.getTitle());

                System.out.println("Switching to main window...");
            }
        }
        //Main tab section
        driver.switchTo().window(ParentWindow);
    }
}