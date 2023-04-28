package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObjectModel {

    public static void main(String args[]) {
        System.setProperty("webdriver.chrome.driver", "/Users/banuandreicristian/Documents/WebDrivers/chromedriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        driver.manage().window().maximize();

        Google_Search.TextField(driver).sendKeys("Page Object Model");
        Google_Search.Search(driver);

        driver.close();
    }
}
