import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa. selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org. testng.annotations.Test;

public class BrowserStack {
    public static final String USERNAME = "alchemytrainingl";
    public static final String AUTOMATE_KEY = "Pws3iMgtEquDxq
    public static final String URL = "https://" + USERNAME + " " + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Test
    public void executeSessionOne() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os", "Windows");
        caps.setCapability("os version", "10");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "80");
        caps.setCapability("name", "alchemytrainingi's First Test");
        WebDriver driver = new RemoteWebDriver(new URL (URL), caps);
        driver.get("http://www.google.com");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.quit();
    }

    @Test
    public void executeSessionTwo() throws MalformedURLException{
        DesiredCapabilities caps = new DesiredCapabilities ();
        caps.setCapability"os version", "11");
        caps.setCapability("device", "iPhone 8 Plus");
        caps.setCapability("real mobile", "true");
        caps.setCapability("browserstack.local", "false");

        //Second session of WebDriver
        WebDriver driver = new RemoteWebDriver(new URL (URL), caps);
        driver.get("https://login.yahoo.com/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.quit();
    }

    @Test
    public void executSessionThree () throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os", "os X");
        caps.setCapability("os_version", "Catalina");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "83.0");
        caps.setCapability("browserstack.local", "false");
        caps.setCapability("browserstack.selenium version", "3.5.2");
        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        driver.get("https://www.browserstack.com/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDs);
        driver.quit();
    }
}