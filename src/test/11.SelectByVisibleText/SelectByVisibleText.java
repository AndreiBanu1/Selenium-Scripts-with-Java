import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EasyTesting {

    public static void main(String[] args) {

        // Path of the chromedriver.exe file
        System.setProperty("webdriver.chrome.driver", "C://Selenium//driver//chromedriver_win32//chromedriver.exe");

        // Creating object of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // URL of the web page to be opened
        String URL = "http://localhost:5000/easytesting";

        // Open the URL in the Chrome browser
        driver.get(URL);

        try {
            // Maximizing the window
            driver.manage().window().maximize();

            // Entering the email and password
            driver.findElement(By.id("inputEmail4")).sendKeys("Alan_Alford63@hotmail.com");
            driver.findElement(By.id("inputPassword4")).sendKeys("Alan_Alford63");

            // Entering the address details
            driver.findElement(By.id("inputAddress")).sendKeys("3077b Oak Ave");
            driver.findElement(By.id("inputAddress2")).sendKeys("Newton Building, Ste 472");
            driver.findElement(By.id("inputCity")).sendKeys("Seattle");

            // Selecting multiple options
            Select options = new Select(driver.findElement(By.id("input")));
            options.selectByVisibleText("stockings");
            options.selectByVisibleText("Skirt");
            options.selectByVisibleText("Pants");

            driver.findElement(By.id("inputZip")).sendKeys("WA 98195");
            System.out.println("Test Case Passed : ");

        } catch (Exception e) {
            System.out.println("Test Case Failed : " + e.getMessage());
        } finally {
            // Closing the browser window
            driver.close();
        }
    }
}
