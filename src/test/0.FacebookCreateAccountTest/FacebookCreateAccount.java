import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookCreateAccount {
    public void createAccount() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/banuandreicristian/Documents/WebDrivers/chromedriver/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.get("http://www.facebook.com");
        driver.manage().window().maximize();

        try {
            WebElement acceptAllButton = driver.findElement(By.xpath("//button[contains(text(), 'Allow essential and optional cookies')]"));
            acceptAllButton.click();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        WebElement createAccountLink = driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']"));
        createAccountLink.click();
        Thread.sleep(3000);

        WebElement name = driver.findElement(By.cssSelector("input[aria-label='First name'][placeholder='First name']"));
        name.sendKeys("John");

        WebElement surname = driver.findElement(By.cssSelector("input[name='lastname']"));
        surname.sendKeys("Doe");

        WebElement email = driver.findElement(By.cssSelector("input[name='reg_email__']"));
        email.sendKeys("abcd@gmail.com");

        WebElement reemail = driver.findElement(By.cssSelector("input[name='reg_email_confirmation__']"));
        reemail.sendKeys("abcd@gmail.com");

        WebElement password = driver.findElement(By.cssSelector("input[name='reg_passwd__']"));
        password.sendKeys("random@password1234");

        WebElement day= driver.findElement(By.id("day"));
        Select oSelect = new Select(day);
        oSelect.selectByIndex(24);

        WebElement month = driver.findElement(By.id("month"));
        Select month_m1 = new Select(month);
        month_m1.selectByVisibleText("Oct");

        WebElement year = driver.findElement(By.id("year"));
        Select year_y1 = new Select(year);
        year_y1.selectByValue("1997");

        WebElement gender = driver.findElement(By.xpath("//label[contains(text(), 'Male')]"));
        gender.click();

        WebElement signUp = driver.findElement(By.xpath("//button[contains(text(), 'Sign Up')]"));
        signUp.click();

        driver.quit();

    }
}
