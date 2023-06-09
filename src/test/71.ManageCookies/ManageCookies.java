import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openga.selenium.chrome.ChromeDriver;

public class Session Cookie {
    public static void main(String[] args)
        WebDriver driver;
        System.setProperty("webdriver.gecko.driver", "/Users/banuandreicristian/Documents/WebDrivers/geckodriver/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/form/button/i").click();

        // Input Email id and Password If you are already Register

    // create file named Cookies to store Login Information
            File file = new File("Cookies.data");
            try

    {
// Delete old file if exists
        file.delete();
        file.createNewFile();
        FileWriter fileWrite = new FileWriter(file);
        BufferedWriter Bwrite = new BufferedWriter(fileWrite);
// loop for getting the cookie information
// loop for getting the cookie information
        for (Cookie ck : driver.manage().getCookies()) {
            Bwrite.write((ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() + ";" + ck.getExpiry() + ";" + ck.isSecure()));
            Bwrite.newLine();
        }
        Bwrite.close();
        fileWrite.close();
    }
            catch(Exception ex) {
            ex.printStackTrace();
            }
}