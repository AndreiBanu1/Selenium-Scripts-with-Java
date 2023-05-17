import org.openga.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GenerateXMLReports {
    Webdriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "/Users/banuandreicristian/Documents/WebDrivers/geckodriver/geckodriver");
        WebDriver driver = new FirefoxDriver();
    }

    @Test
    public void TestMethod1() {
        driver.get("https://www.google.com/")
        System.out.println("Test Case 1 Passed")
    }

    @Test(dependsOnMethods={"TestMethod1"})
    public void TestMethod2() {
        System.out.println(driver.getTitle());
        System.out.println("Test Case 2 Passed");
    }

    @Test(dependsOnMethods={"TestMethod1"})
    public void TestMethod3() {
        driver.findElement(By.name("q")).sendKeys("Selenium");
        System.out.println("Test Case 3 Passed");
    }
}