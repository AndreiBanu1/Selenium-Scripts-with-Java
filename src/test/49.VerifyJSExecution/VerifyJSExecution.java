import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class VerifyJSExecution {
        WebDriver driver;

        try {
        System.setProperty("webdriver.gecko.driver", "/Users/banuandreicristian/Documents/WebDrivers/geckodriver/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        String url = "https://www.localhost:5000/action";
        driver.get(url);
        Thread.sleep(5000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return document.getElementById('myBtn').click();");

        System.out.println("Test Case Passed");

        driver.quit();
        } catch (InterruptedException e) {
        e.printStackTrace();
        } catch (Exception e) {
        System.out.println("Test Case Failed:");
        e.printStackTrace();
        }
}
