import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class ResizeWebElements {
    @Test
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/Users/banuandreicristian/Documents/WebDrivers/geckodriver/geckodriver");

        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost:5000/resize");
        driver.manage().window().maximize();

        driver.switchTo().frame(driver.findElement(By.id("frame")));
        WebElement widget = driver.findElement(By.xpath("/html/body/div[1]/div[3]"));
        Actions act = new Actions(driver);

        //Code for resize
        act.clickAndHold(widget).moveByOffset(100, 100).release().build().perform();

        System.out.println("Resized successfully");
    }
}
