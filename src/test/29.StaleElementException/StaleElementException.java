import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StaleElementExceptionDemo {

    public static void main(String[] args) {
        String driverPath = "/Users/banuandreicristian/Documents/WebDrivers/geckodriver/geckodriver";
        String url = "http://localhost:5000/stale";
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();

        WebElement usernameElement = driver.findElement(By.id("idUsername"));
        WebElement passwordElement = driver.findElement(By.id("idPassword"));

        usernameElement.sendKeys("testuser");

        driver.findElement(By.id("reloadLink")).click();

        try {
            passwordElement.sendKeys("password");
        } catch (StaleElementReferenceException e) {
            System.out.println("Trying to find element again: - Test case Passed");
            passwordElement = driver.findElement(By.id("idPassword"));
            passwordElement.sendKeys("password");
        }

        driver.quit();
    }
}
