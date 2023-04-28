import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        String URL = "http://localhost:5000/easytesting";
        driver.get(URL);

        try {
            driver.manage().window().maximize();
            driver.findElement(By.name("btnk")).click();

            // Provides all window handle value
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
                System.out.println(handle);
                // Switching to the desired window
                if (driver.getTitle().equals("Advertisement")) {
                    System.out.println("Advertisement Window Closed");
                    driver.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Test Case Failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
