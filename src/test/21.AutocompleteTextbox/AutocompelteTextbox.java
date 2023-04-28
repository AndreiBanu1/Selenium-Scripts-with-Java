import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {

    public static void main(String[] args) {

        String driverPath = "/Users/banuandreicristian/Documents/WebDrivers/geckodriver/geckodriver";
        System.setProperty("webdriver.gecko.driver", driverPath);
        WebDriver driver = new FirefoxDriver();
        String URL = "http://localhost:5000/easytesting";
        driver.get(URL);

        try {
            driver.manage().window().maximize();
            WebElement suggestionBox = driver.findElement(By.id("myInput"));
            suggestionBox.sendKeys("In");
            suggestionBox.sendKeys(Keys.ARROW_DOWN);
            suggestionBox.sendKeys(Keys.RETURN);
            System.out.println("Tested Autocomplete");

        } catch (Exception e) {
            System.out.println("ERROR : " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
