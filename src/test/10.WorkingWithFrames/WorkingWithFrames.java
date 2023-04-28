import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FrameHandlingExample {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C://Selenium//driver//chromedriver_win32//chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            String URL = "http://localhost:5000/easytesting";
            driver.get(URL);
            driver.manage().window().maximize();

            // Frame1 Operations
            WebElement email = driver.findElement(By.id("exampleInputEmaill"));
            email.sendKeys("Alan_Alford63@hotmail.com");

            WebElement password = driver.findElement(By.id("exampleInputPassword1"));
            password.sendKeys("Alan Alford63");

            // Switch to Frame2
            driver.switchTo().frame("frame2");

            WebElement inputEmail = driver.findElement(By.id("inputEmail4"));
            inputEmail.sendKeys("Alan_Alford63@hotmail.com");

            WebElement inputPassword = driver.findElement(By.id("inputPassword4"));
            inputPassword.sendKeys("Alan_Alford63");

            WebElement inputAddress = driver.findElement(By.id("inputAddress"));
            inputAddress.sendKeys("3077b Oak Ave");

            WebElement inputAddress2 = driver.findElement(By.id("inputAddress2"));
            inputAddress2.sendKeys("Newton Building, Ste 472");

            WebElement inputCity = driver.findElement(By.id("inputCity"));
            inputCity.sendKeys("Seattle");

            WebElement inputZip = driver.findElement(By.id("inputZip"));
            inputZip.sendKeys("WA 98195");

            System.out.println("Test Case Passed");
        } catch (Exception e) {
            System.out.println("Test Case Failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
