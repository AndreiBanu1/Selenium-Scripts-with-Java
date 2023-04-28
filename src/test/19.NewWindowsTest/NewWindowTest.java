import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Example {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        String URL = "http://localhost:5000/easytesting";
        driver.get(URL);

        try {
            driver.manage().window().maximize();
            driver.findElement(By.id("btnk")).click();
            System.out.println(driver.getWindowHandle());
            // Provides all windows handle value
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
                // Switching to the desired window
                if (driver.getTitle().equals("Hotel feedback")) {

                    driver.findElement(By.id("exampleFormControlInput1")).sendKeys("Alan_Alford63@hotmail.com");

                    Select Rating = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
                    // by value
                    Rating.selectByValue("1");

                    Select Problem = new Select(driver.findElement(By.id("exampleFormControlSelect2")));
                    // by value
                    Problem.selectByValue("AC");
                    Problem.selectByValue("Wifi");

                    driver.findElement(By.id("exampleFormControlTextareal")).sendKeys("Not Satisfactory");
                    System.out.println(driver.getTitle());
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
