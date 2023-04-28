import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

public class TakeScreenshot {
    public static void main(String[] args) throws IOException {
        String driverPath = "/Users/banuandreicristian/Documents/WebDrivers/geckodriver/geckodriver";

        // Set Firefox options
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--start-maximized");

        // Initialize the Firefox browser
        System.setProperty("webdriver.gecko.driver", driverPath);
        WebDriver driver = new FirefoxDriver(firefoxOptions);

        try {
            String url = "http://localhost:3000/";
            driver.get(url);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            // Take a screenshot of the landing page
            File landingPageScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path landingPageScreenshotPath = Files.move(landingPageScreenshot.toPath(),
                    Path.of("Landing_Page.png"));

            driver.findElement(By.xpath("/html/body/div[1]/nav/div[2]/div[2]/ul/li[2]/a")).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            // Take a screenshot of the login page
            File loginPageScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path loginPageScreenshotPath = Files.move(loginPageScreenshot.toPath(),
                    Path.of("Login_Page.png"));

            driver.findElement(By.id("email")).sendKeys("Alchemytraining123@gmail.com");
            driver.findElement(By.id("password")).sendKeys("P@ssword@123");
            driver.findElement(By.id("btn")).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            // Take a screenshot of the dashboard
            File dashboardScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path dashboardScreenshotPath = Files.move(dashboardScreenshot.toPath(),
                    Path.of("Dashboard.png"));

            System.out.println("Test Case Passed: ");
        } catch (Exception e) {
            System.out.println("Test Case Failed : ");
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
