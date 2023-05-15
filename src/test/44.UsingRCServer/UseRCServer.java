import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class UseRCServer() {
        WebDriver driver;

        try {
        URL remoteUrl = new URL("http://192.168.100.37:4444/wd/hub");
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        String URL = "https://www.google.com";
        driver.get(URL);
        Thread.sleep(5000);

        System.out.println(driver.getTitle());
        System.out.println("Test Case Passed");

        driver.quit();
        } catch (MalformedURLException e) {
        e.printStackTrace();
        } catch (InterruptedException e) {
        e.printStackTrace();
        } catch (Exception e) {
        System.out.println("Test Case Failed:");
        e.printStackTrace();
        }
}
