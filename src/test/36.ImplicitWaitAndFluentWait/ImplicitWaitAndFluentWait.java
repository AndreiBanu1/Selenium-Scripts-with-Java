import com.google.common.util.concurrent.FluentFuture;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class ImplicitWaitAndFluentWait {
    @Test
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/Users/banuandreicristian/Documents/WebDrivers/geckodriver/geckodriver");

        WebDriver driver = new FirefoxDriver();
        driver.get("https://covid-19-dc.herokuapp.com/");
        driver.manage().window().maximize();

//        //Implicit wait
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        driver.findElement(By.xpath("//*[@id=\"IN\"]")).click();

        //Fluent wait
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        WebElement clickMap = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(By.xpath("//*[@id=\"IN\"]"));
            }
        });
    }
}
