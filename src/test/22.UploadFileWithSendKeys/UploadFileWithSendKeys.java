import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UploadFileExample {

    public static void main(String[] args) {
        String driverPath = "/Users/banuandreicristian/Documents/WebDrivers/geckodriver/geckodriver";
        WebDriver driver = new FirefoxDriver();
        String URL = "http://localhost:5000/upload";
        driver.get(URL);

        try {
            driver.manage().window().maximize();
            driver.findElement(By.id("exampleFormControlfilel")).sendKeys("C://Users/HP/Desktop/Alex/Alex_doc.docx");
            System.out.println("File Uploaded Successfully");
        } catch (Exception e) {
            System.out.println("ERROR : " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
