import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By
import org.openqa.selenium.WebElement;
import org.openqa. selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserStack {
    public static final String USERNAME = "alchemytrainingl";
    public static final String AUTOMATE_KEY = "Pws3iMgtEquDxq
    public static final String URL = "https://" + USERNAME + " " + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static void main(String[] args) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        caps.setCapability("os", "OS X");
        caps.setCapability("os_version", "Catalina");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "83.0");
        caps.setCapability("project", "SSL_Certificate");
        caps.setCapability("build_version_certificate", "SSL V.0.1");
        caps.setCapability("name", "SSL_bypass");
        caps.setCapability("browserstack.local", "false");
        caps.setCapability("browserstack.selenium_version", "3.5.2");

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.cacert.org");

        System.out.println(driver.getTitle());
        driver.quit();
    }
}