import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AuthInFirefox {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/Users/banuandreicristian/Documents/WebDrivers/geckodriver/geckodriver");

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/basic_auth");
        String Msg = driver.findElement(By.cssSelector("p")).getText();
        System.out.println(Msg);
        driver.close();
    }
}
