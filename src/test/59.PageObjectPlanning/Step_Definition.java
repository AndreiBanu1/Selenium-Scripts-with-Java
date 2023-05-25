import java.util.concurrent. TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium. chrome.ChromeDriver;
import org.testng. Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class Step Defination {
    WebDriver driver;

    @Given(" User have opened the browser$")
    public void Open_the_browser() throws Throwable {
        System.setProperty("webdriver.gecko.driver", "/Users/banuandreicristian/Documents/WebDrivers/geckodriver/geckodriver");
        WebDriver driver = new FirefoxDriver();
    }

    @When("^User have opened Google webpage and verify the title$")
    public void Navigating_to_Google_Page() throws Throwable {
        driver.get("http://google.com");

        driver.manage().window().maximize();
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Google";

        //Soft assert applied to verify title
        Assert.assertEquals(ActualTitle, ExpectedTitle)
    }

    @When("^User entered Text as \"([^\"]*)\" to search$")
    public void Search(String arg1) throws Throwable {
        Google_Page_Object pom = new Google_Page_Object(driver);
        pom.textbox(arg1);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pom.SearchButton();
    }
}