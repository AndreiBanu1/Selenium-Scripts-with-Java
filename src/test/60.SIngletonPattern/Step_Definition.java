import java.util.concurrent. TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class Step_Defination {
    WebDriver driver;

    @Given(" User have opened the browser$")
    public void Open_the_browser() throws Throwable {
        SingletonBrowserClass sbc1 = SingletonBrowserClass.getInstanceOfSingletonBrowserClass();
        WebDriver driver1 = sbc1.getDriver();
        driver1.get("https://login.yahoo.com");

        SingletonBrowserClass sbc2 = SingletonBrowserClass.getInstanceOfSingletonBrowserClass();
        WebDriver driver2 = sbc2.getDriver();
        driver2.get("https://www.google.com")
    }
}