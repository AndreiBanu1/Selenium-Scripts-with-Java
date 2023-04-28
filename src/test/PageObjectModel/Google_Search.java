package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Google_Search {
    private static WebElement Element=null;
        public static WebElement TextField(WebDriver driver) {
            Element=driver.findElement(By.name("q"));
            return Element;
        }

        public static WebElement Search(WebDriver driver) {
            Element=driver.findElement(By.name("btnk"));
            return Element;
        }

}
