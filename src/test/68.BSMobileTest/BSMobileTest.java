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

    public static void main (String[] args) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os version", "13");
        caps.setCapability("device", "iPhone XS");
        caps.setCapability("real_mobile", "true");
        caps.setcapability("project", "Verify Google search Title");
        caps.setCapability("build", "V.O.1");
        caps.setCapability( "name", "Verify Title");
        caps.setCapability("browserstack.local", "false")

        WebDriver driver = new RemoteWebDriver(new URL (URL), caps);
        driver.get("http://www.google.com");
        Webelement element = driver.findElement(By.name ("a"));
        element.sendKeys("BrowserStack");
        element.submit();
        String Actual = driver.getTitle();
        String Expected = "BrowserStack-Google Search";
        if (Actual.equals(Expected)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        driver.quit ();
    }
}