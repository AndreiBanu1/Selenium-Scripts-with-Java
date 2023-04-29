import java.io.IOException;
import java.net.MalformedURLException;
import org.openqa.selenium. By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Element Not Clickable {

    public static void main (String args []) throws MalformedURLException, IOEX {
        System.setProperty("webdriver.gecko.driver", "/Users/banuandreicristian/Documents/WebDrivers/geckodriver/geckodriver");

        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("http://login.yahoo.com");
//        driver.findElement(By.id("persistent")).click();

        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.id("persisent"))).click().build().perform();
        System.out.println("Test Case Passsed");
    }
}
