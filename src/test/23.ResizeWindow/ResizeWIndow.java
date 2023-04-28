import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ResponsiveUITest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            String URL = "http://localhost:5000/easytesting";
            driver.get(URL);
            driver.manage().window().setSize(new Dimension(600, 700));
            driver.manage().window().setPosition(new Point(150, 150));
            WebElement navbarToggler = driver.findElement(By.className("navbar-toggler-icon"));
            navbarToggler.click();
            System.out.println("UI is responsive, Test case Passed");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
