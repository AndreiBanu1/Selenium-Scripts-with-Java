import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AutoITScript {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/Users/banuandreicristian/Documents/WebDrivers/geckodriver/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        This is the line where the script created is running
        Runtime.getRuntime().exec("/Users/banuandreicristian/Documents/AutoIT/Auto");

        driver.get("https://the-internet.herokuapp.com/basic_auth");
    }
}
