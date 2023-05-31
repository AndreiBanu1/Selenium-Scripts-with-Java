import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Step_Definition {
    WebDriver driver;

    @Given("^User have opened the browser$")
    public void Setup(){
        System.setProperty("webdriver.gecko.driver", "/Users/banuandreicristian/Documents/WebDrivers/geckodriver/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        System.out.println("Browser opened successfully");
    }

    @When("^User have opened EasyTesting website and verify the title$")
    public void Navigation() {
        driver.get("http://localhost:3000/login")
        System.out.println("Navigated to Easy Testing");

        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Easy Testing";

        Assert.assertEquals(ActualTitle, ExpectedTitle);
    }

    @When("^User entered username as \"([^\"]*)\" and feedback as \"([^\"]*)\"$")
    public void Login_Auth(String arg1, String arg2) throws Throwable {
        EasyTesting_Page_Object pom = new EasyTesting_Page_Object(driver);

        pom.email(arg1);
        pom.Rating(1);
        pom.Problem_Faced(4);
        pom.feedback(arg2);
    }
}