import org.jboss.aerogear.security.otp.Totp;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class TwoFactorAuth {
    @Test
    public void twoFactorAuthentication() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("localhost:52375/Account/Login");
        driver.findElement(By.id("Input_Email")).sendKeys("foo@example.com");
        driver.findElement(By.id("Input_Password")).sendKeys("P@ssw0rd");
        driver.findElement(By.id("btn-login")).click();

        // Compute 2FA Code,
        String otpKeyStr = "6jm7n6xwitpjooh7ihewyyzeux7aqmw2"; // <- this 2FA secret key.

        Totp totp = new Totp(otpKeyStr);
        String twoFactorCode = totp.now(); // <- got 2FA coed at this time!

        driver.findElement(By.id("Input_TwoFactorCode")).sendKeys(twoFactorCode);
        driver.findElement(By.id("btn-login")).click();


        driver.quit();
    }
}