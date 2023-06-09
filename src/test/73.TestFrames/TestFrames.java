import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest {
    public static void main(String[] args) {
        String driverPath = "/Users/banuandreicristian/Documents/WebDrivers/geckodriver/geckodriver";
        System.setProperty("webdriver.gecko.driver", driverPath);

        WebDriver driver = new FirefoxDriver();

        try {
            String url = "http://localhost:5000/easytesting";
            driver.get(url);
            driver.manage().window().maximize();

            // Frame Operations
            driver.findElement(By.id("exampleFormControlInput1")).sendKeys("Alan_Alford63@hotmail.com");
            driver.findElement(By.id("exampleFormControlTextareal")).sendKeys("Satisfactory");

            // Switch to frame2
            driver.switchTo().frame("frame2");

            driver.findElement(By.id("inputEmail4")).sendKeys("Alan_Alford63@hotmail.com");
            driver.findElement(By.id("inputPassword4")).sendKeys("Alan_Alford63");
            driver.findElement(By.id("inputAddress")).sendKeys("3077b Oak Ave");
            driver.findElement(By.id("inputAddress2")).sendKeys("Newton Building, Ste 472");
            driver.findElement(By.id("inputCity")).sendKeys("Seattle");
            driver.findElement(By.id("inputZip")).sendKeys("WA 98195");

            System.out.println("Test Case Passed.");
        } catch (Exception e) {
            System.out.println("Test Case Failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
