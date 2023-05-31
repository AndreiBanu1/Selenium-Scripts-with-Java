import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class EasyTesting_Page_Object {
    WebDriver driver= null;

    //Keep on locating Objects here
    By email = By.id("exmapleFormControlInput1");
    By textbox = By.id("exmapleFormControlTextarea1");
    By button = By.id("btn");
    By Rating = By.id("exampleFormControlSelect1");
    By service = By.id("exmapleFormControlSelect2");

    //Constructor for using test class driver object

    public EasyTesting_Page_Object(WebDriver driver) {
        this.driver = driver;
    }

    //Actions on those Objects
    public void feedback(String text) {
        driver.findlement(textbox).sendKeys("text");
    }

    public void Rating(int i) {
        Select dropCountry = new Select(driver.findElement(Rating));
        drpCountry.selectByIndex(i);
    }

    public void Problem_Faced(int i) {
        Select compl = new Select(driver.findElement(service));
        compl.selectByIndex(i);
    }

    public void email(String text) {
        driver.findElement(email).sendKeys(text);
    }

    public void SearchButton() {
        driver.findElement(Button).sendKeys(Keys.RETURN);
    }
}