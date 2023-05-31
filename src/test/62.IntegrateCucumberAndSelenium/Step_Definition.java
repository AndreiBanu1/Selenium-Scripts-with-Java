import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

    @When("^User have opened EasyTesting website$")
    public void Navigation() {
        driver.get("http://localhost:3000/login")
        System.out.println("Navigated to Easy Testing");
    }

    @When("^User entered username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void Login_Auth(String arg1, String arg2) throws Throwable {
        driver.findElement(By.id("email")).sendKeys(arg1);
        driver.findElement(By.id("password")).sendKeys(arg2);
        System.out.println("Filled the Credentials");
    }

    @Then("^Login button should exist$")
    public void login_button_should_exist() throws Throwable {
        driver.findElement(By.id("btn")).click();
        System.out.prinln("Logged in Successfully");
    }
}