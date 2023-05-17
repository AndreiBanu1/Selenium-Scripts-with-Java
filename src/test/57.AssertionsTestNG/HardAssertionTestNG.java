import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;I

public class HardAssertion {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
    }

    @Test
    public void verifyTitle() {
        driver.get("https://www.Google.com");
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Welcome to Google";
        Assert.assertEquals(ActualTitle, ExpectedTitle);
        System.out.println("This Statement is not going to print");
    }

    @AfterTest
    public void closedriver(){
        //closes the browser instance
        driver.close();
}