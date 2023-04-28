import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        String URL = "http://localhost:5000/easytesting";
        driver.get(URL);

        try {
            driver.manage().window().maximize();
            driver.findElement(By.id("exampleFormControlInput1")).sendKeys("Alan_Alford63@hotmail.com");
            Select rating = new Select(driver.findElement(By.id("exampleFormControlSelect1")));

            // by value
            rating.selectByValue("1");
            Select problem = new Select(driver.findElement(By.id("exampleFormControlSelect2")));

            // by value
            problem.selectByValue("AC");
            problem.selectByValue("Wifi");

            problem.deselectAll();
            driver.findElement(By.id("exampleFormControlTextarea1")).sendKeys("Not Satisfactory");
            System.out.println("Test Case Passed : ");

        } catch (Exception e) {
            System.out.println("Test Case Failed : ");
        } finally {
            driver.quit();
        }
    }
}
