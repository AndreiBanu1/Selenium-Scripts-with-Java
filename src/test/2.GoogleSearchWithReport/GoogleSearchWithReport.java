import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.*;

public class GoogleSearch {

    private static WebDriver driver = null;
    private static ExtentReports extent;
    private static ExtentTest logger;

    @BeforeClass
    public static void setUp() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("Reports/google_search_report.html");
        extent.attachReporter(spark);
        logger = extent.createTest("GoogleSearch");

        String driverPath = ChromeDriverManager.getInstance().install();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.get("http://www.google.com/");
    }

    @Test
    public void testSearch() {
        // accept cookies
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement cookiesField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='tHlp8d']")));
            cookiesField.click();
            logger.log(Status.INFO, "Cookies accepted");
        } catch (Exception e) {
            logger.log(Status.ERROR, "No cookies to accept");
            driver.close();
        }

        // get the search textbox
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(By.tagName("textarea")));
        // enter search keyword and submit
        searchField.sendKeys("Selenium WebDriver Interview Question");
        searchField.submit();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
        extent.flush();
        logger.log(Status.INFO, "Test Completed");
    }
}
