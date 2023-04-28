import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class HandleSSLCertificate {
    @Test
    public static void main(String[] args) throws IOException,InterruptedException {
        FirefoxOptions fo = new FirefoxOptions();
        fo.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

        System.setProperty("webdriver.gecko.driver", "/Users/banuandreicristian/Documents/WebDrivers/geckodriver/geckodriver");

        WebDriver driver = new FirefoxDriver(fo);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://cacert.org");
        System.out.println(driver.getTitle());
        driver.close();
    }
}


