import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriverService;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicAuth {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriverManager.chromedriver().setup();
        ChromeDriverService service = ChromeDriverService.createDefaultService();
        WebDriver driver = new ChromeDriver(service, options);

        //username and password in the URL
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        driver.manage().window().maximize();
    }
}
