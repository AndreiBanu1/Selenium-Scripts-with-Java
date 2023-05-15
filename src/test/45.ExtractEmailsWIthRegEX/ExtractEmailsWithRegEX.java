import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmailWithRegEX main(String[] args) {
        WebDriver driver;

        try {
        System.setProperty("webdriver.gecko.driver", "/Users/banuandreicristian/Documents/WebDrivers/geckodriver/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        String url = "https://localhost:5000/emails";
        driver.get(url);
        Thread.sleep(5000);

        String doc = driver.getPageSource();
        Pattern pattern = Pattern.compile("[\\w\\.-]+@[\\w\\.-]+");
        Matcher matcher = pattern.matcher(doc);
        while (matcher.find()) {
        String email = matcher.group();
        System.out.println(email);
        }

        System.out.println("Test Case Passed");

        driver.quit();
        } catch (InterruptedException e) {
        e.printStackTrace();
        } catch (Exception e) {
        System.out.println("Test Case Failed:");
        e.printStackTrace();
        }
}
