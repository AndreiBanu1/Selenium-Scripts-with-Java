import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

    public static void main(String[] args) {
        // Set path to GeckoDriver executable
        System.setProperty("webdriver.gecko.driver", "/Users/banuandreicristian/Documents/WebDrivers/geckodriver/geckodriver");

        // Initialize the Firefox browser
        WebDriver driver = new FirefoxDriver();

        try {
            String URL = "http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html";
            driver.get(URL);
            driver.manage().window().maximize();
            Thread.sleep(5000);

            WebElement sourceElement = driver.findElement(By.xpath("//*[@id=\"box6\"]"));
            WebElement destElement = driver.findElement(By.xpath("//*[@id=\"box106\"]"));
            Thread.sleep(2000);
            Actions actions = new Actions(driver);
            actions.dragAndDrop(sourceElement, destElement).build().perform();
            System.out.println("Test Case Passed : ");

        } catch (Exception e) {
            System.out.println("Test Case Failed : ");
        } finally {
            driver.quit();
        }
    }
}
