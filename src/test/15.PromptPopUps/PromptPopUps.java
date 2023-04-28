import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PromptPopUps {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/banuandreicristian/Documents/WebDrivers/chromedriver/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Alert Message handling
        driver.get("http://localhost:5000/easytesting");
        driver.findElement(By.id("submit")).click();

        //Switching to Alert
        Alert alert = driver.switchTo().alert();

        //Send data in alert box
        alert.sendKeys("Andrei");
        Thread.sleep(1000);

        //Capturing alert message
        String alertMessage = alert.getText();

        //Displaying alert message
        System.out.println(alertMessage);
        Thread.sleep(5000);

        //Accepting alert
        alert.accept();
    }
}