import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class TestingContextMenu {

    public static void main(String[] args) {
        // Set path to GeckoDriver executable
        System.setProperty("webdriver.gecko.driver", "/Users/banuandreicristian/Documents/WebDrivers/geckodriver/geckodriver");

        // Initialize the Firefox browser
        WebDriver driver = new FirefoxDriver();

        try {
            String URL = "http://localhost:5000/easytesting";
            driver.get(URL);
            driver.manage().window().maximize();
            Thread.sleep(5000);

            WebElement element = driver.findElement(By.id("menu"));
            Thread.sleep(2000);
            Actions actions = new Actions(driver);
            Action contextClick = actions.contextClick(element).build();
            contextClick.perform();

            System.out.println("Test Case Passed : ");

        } catch (Exception e) {
            System.out.println("Test Case Failed : ");
        } finally {
            driver.quit();
        }
    }
}
