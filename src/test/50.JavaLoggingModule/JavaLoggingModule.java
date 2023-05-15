import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class JavaLoggingModule() {
        Logger logger = Logger.getLogger(Main.class.getName());
        FileHandler fileHandler;

        try {
        fileHandler = new FileHandler("logging_example.out");
        fileHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(fileHandler);
        logger.setLevel(Level.ALL);

        System.setProperty("webdriver.gecko.driver", "/Users/banuandreicristian/Documents/WebDrivers/geckodriver/geckodriver");
        WebDriver driver = new FirefoxDriver();

        driver.get("http://www.google.com");

        logger.log(Level.INFO, "Firefox Instance Started and working fine");
        logger.log(Level.INFO, "Browser Version printed");

        driver.quit();
        } catch (Exception e) {
        logger.log(Level.SEVERE, "Test Case Failed", e);
        }
}
