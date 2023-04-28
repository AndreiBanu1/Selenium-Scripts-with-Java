import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        String URL = "http://localhost:5000/easytesting";
        driver.get(URL);
        driver.manage().window().maximize();

        driver.findElement(By.id("exampleInputEmaill")).sendKeys("Alan Alford63@hotmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("Alan Alford63");

        // Handling Multiple checkbox
        WebElement privacyPolicy = driver.findElement(By.id("privacypolicy"));
        WebElement TNC = driver.findElement(By.id("TNC"));
        privacyPolicy.click();
        TNC.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // To verify or get selection status
        String isChecked = privacyPolicy.getAttribute("checked");
        if (isChecked != null) {
            System.out.println("Element checked - " + isChecked);
        } else {
            System.out.println("Element checked - false");
        }
        driver.quit();
    }
}
