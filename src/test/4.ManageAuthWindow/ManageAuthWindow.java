import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriverService;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// I. Basic AUTH using web url for providing credentials
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

// II. Auth using wait method and alert object
public class HandleAuthenticationPopup {

    public static void main(String[] args) {
        // Setting up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Navigate to the webpage of interest
        driver.get("http://the-internet.herokuapp.com/basic_auth");

        // Wait for the alert to pop up
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        // Authenticate using username and password
        String username = "username";
        String password = "password";
        alert.authenticateUsing(new UserAndPassword(username, password));

        // Verify that the page has been authenticated
        String expectedText = "Congratulations! You must have the proper credentials.";
        String actualText = driver.findElement(By.tagName("p")).getText();
        if (actualText.equals(expectedText)) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed!");
        }

        // Close the browser
        driver.quit();
    }
}
