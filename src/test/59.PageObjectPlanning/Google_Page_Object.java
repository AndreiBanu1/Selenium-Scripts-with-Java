import org.openqa.selenium. By;
import org.openqa.selenium. Keys;
import org.openqa.selenium.WebDriver;

public class Google_Page_Object {
    WebDriver driver=null;

//Keep on locating Objects here
    By textbox=By.name ("a");
    By Button=By.className ("gNO89b");

//Constructor for Using test class driver object
    public Google_Page_Object(WebDriver driver) {
        this.driver = driver;
    }

//Actions on those objects
    public void textbox(String text) {
        driver.findElement(textbox).sendKeys(text);
    }

    public void SearchButton() {
        driver.findElement(Button).sendKeys(Keys.RETURN);
    }

}