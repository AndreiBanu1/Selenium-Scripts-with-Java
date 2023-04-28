import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.testng.annotations.Test;

import java.time.Duration;

public class ScrollVertically {
    @Test
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/Users/banuandreicristian/Documents/WebDrivers/geckodriver/geckodriver");

        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://localhost:5000/easytesting");

        JavascriptExecutor js=(JavascriptExecutor)driver;

        //scroll to bottom of the page
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        //scroll to coordinates
        js.executeScript("scroll(0, 70)");

        //scroll to page element
        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[3]"));
        Coordinates coordinates = ((Locatable)element).getCoordinates();
        coordinates.onPage(); //get the coordinates of the element in relative to the top left corner of web application
        coordinates.inViewPort(); //get the coordinates of the element relative to the top left corner of OS system window


        System.out.println("Scrolled successfully");
    }
}
