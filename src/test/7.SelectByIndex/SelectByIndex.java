import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EasyTesting {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        String URL = "http://localhost:5000/easytesting";
        driver.get(URL);

        try {
            driver.manage().window().maximize();
            driver.findElement(By.id("inputEmail4")).sendKeys("Alan_Alford63@hotmail.com");
            driver.findElement(By.id("inputPassword4")).sendKeys("Alan_Alford63");
            driver.findElement(By.id("inputAddress")).sendKeys("3077b Oak Ave");
            driver.findElement(By.id("inputAddress2")).sendKeys("Newton Building, Ste 472");
            driver.findElement(By.id("inputCity")).sendKeys("Seattle");
            driver.findElement(By.id("inputZip")).sendKeys("WA 98195");
            // opting Multi options
            Select opt = new Select(driver.findElement(By.id("inputgadget")));
            opt.selectByIndex(2);
            opt.selectByIndex(1);

            driver.findElement(By.id("inputZip")).sendKeys("WA 98195");
            opt.deselectByIndex(2);
            opt.deselectByIndex(1);
            System.out.println("Test Case Passed : ");

        } catch (Exception e) {
            System.out.println("Test Case Failed: ");
        } finally {
            driver.close();
        }
    }
}
