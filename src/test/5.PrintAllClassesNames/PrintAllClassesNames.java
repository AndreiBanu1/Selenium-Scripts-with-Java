import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleSearch {
    private static WebDriver driver = null;

    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        ChromeService service = new ChromeService.Builder()
                .usingDriverExecutable(ChromeDriverManager.chromedriver().install())
                .build();
        driver = new ChromeDriver(service, options);
        driver.get("http://www.google.com");

        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            for (WebElement element : driver.findElements(By.xpath("//*[@class]"))) {
                System.out.println(element.getAttribute("class"));
            }
        } catch (Exception e) {
            System.out.println("TestCase Failed: ");
        } finally {
            driver.quit();
        }
    }
}
