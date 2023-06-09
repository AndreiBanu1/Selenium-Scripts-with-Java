import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class SeleniumTest {
    private static final Logger logger = Logger.getLogger(SeleniumTest.class.getName());
    private static final String LOG_FILENAME = "Google Search Log.out";

    public static void main(String[] args) {
        try {
            FileHandler fileHandler = new FileHandler(LOG_FILENAME);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String driverPath = "/Users/banuandreicristian/Documents/WebDrivers/geckodriver/geckodriver";
        System.setProperty("webdriver.gecko.driver", driverPath);

        WebDriver driver = new FirefoxDriver();

        try {
            logger.log(Level.INFO, "Firefox instance started and working fine");
            driver.get("http://www.google.com");
            logger.log(Level.INFO, "Navigated to Google webpage");

            boolean isGmailLinkDisplayed = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div[1]/div[1]/a")).isDisplayed();
            logger.log(Level.INFO, "Gmail link is available: " + isGmailLinkDisplayed);

            boolean isImageLinkDisplayed = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div[1]/div[2]/a")).isDisplayed();
            logger.log(Level.INFO, "Image link is available: " + isImageLinkDisplayed);

            driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("Selenium Testing");
            logger.log(Level.INFO, "Typed in Search Textfield");

            driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[2]/div[1]/div[3]/center/input[1]")).click();
            logger.log(Level.INFO, "Clicked on search Button");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Test Case Failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
