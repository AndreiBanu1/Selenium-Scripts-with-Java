import org.openqa.selenium. By;
import org.openqa.selenium.WebDriver;
import org.openga.selenium.chrome.ChromeDriver;

public class WebDriverConditionalCommands {
       System.setProperty("webdriver.gecko.driver", "/Users/banuandreicristian/Documents/WebDrivers/geckodriver/geckodriver");
       WebDriver driver=new FirefoxDriver();
       driver.get("http://localhost:5000/easytesting");
       if (driver.findElement(By.id("exampleInputEmaill")).isDisplayed()) {
           System.out.println("Email Text field is Visible");
    }
       else {
           System.out.println("Email Text field is Not Visible");
    }
       if (driver.findElement(By.id("rec")).isEnabled()) {
        System.out.println("Receive News Letter radio button is Selected.");
       } else {
        System.out.println("Receive News letter radio button is Not Selected.");
    }
}