import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class ReadDataFromFile {
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        System.setProperty("webdriver.gecko.driver", "/Users/banuandreicristian/Documents/WebDrivers/geckodriver/geckodriver");

        WebDriver driver = new FirefoxDriver();

        Properties property = new Properties();
        FileInputStream Objfile = new FileInputStream("/Users/banuandreicristian/Documents/id");

        try {
            property.load(Objfile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        driver.get(property.getProperty("baseURL"));
        driver.manage().window().maximize();
        driver.findElement(By.xpath(property.getProperty("email_field"))).sendKeys(property.getProperty("email"));
        driver.findElement(By.xpath(property.getProperty("password_field"))).sendKeys(property.getProperty("password"));
        driver.findElement(By.xpath(property.getProperty("btn"))).click();
    }
}