import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GetDataFromImage() {
        WebDriver driver;

        try {
        System.setProperty("webdriver.gecko.driver", "/Users/banuandreicristian/Documents/WebDrivers/geckodriver/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        String url = "https://www.localhost:5000/image";
        driver.get(url);
        Thread.sleep(5000);

        List<WebElement> elems = driver.findElements(By.tagName("img"));
        for (WebElement elem : elems) {
        System.out.println(elem.getAttribute("alt"));
        System.out.println(elem.getTagName());
        System.out.println(elem.getLocation());
        System.out.println(elem.getSize());
        }

        System.out.println("Test Case Passed");

        driver.quit();
        } catch (InterruptedException e) {
        e.printStackTrace();
        } catch (Exception e) {
        System.out.println("Test Case Failed:");
        e.printStackTrace();
        }
}
