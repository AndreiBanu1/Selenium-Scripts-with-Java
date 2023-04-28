import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AlertHandling {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C://Selenium//driver//chromedriver_win32//chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        String URL = "https://www.google.com/";
        driver.get(URL);

        try {
            driver.manage().window().maximize();

            driver.executeScript("window.alert('This is alert');");
            TimeUnit.SECONDS.sleep(5);

            Alert alert = driver.switchTo().alert();
            alert.accept();

            System.out.println("Dialog Box Poped-up and Successfully Handled By the script ");

        } catch (Exception e) {
            System.out.println("ERROR : " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
