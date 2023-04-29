import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalendarDatePicker {
    private String demosite = "http://jqueryui.com/resources/demos/datepicker";
    WebDriver browser;
    WebDriverWait wait;

    @BeforeTest
    public void startTest() {

        System.setProperty("webdriver.gecko.driver", "/Users/banuandreicristian/Documents/WebDrivers/geckodriver/geckodriver");

        // Initialize the Firefox browser
        browser = new FirefoxDriver();
        browser.navigate().to(demosite);
        browser.manage().window().maximize();
    }

    @Test
    public void jQueryCalendarMultipleMonths() throws InterruptedException {

        // Click to open the date time picker calendar.
        WebElement calElement = browser.findElement(By.id("datepicker"));
        calElement.click();

        //Provide the day of the month to select the date.
        SelectDayFromMultipleDateCalendar("17");
    }

    // Function to select the day of month in the date picker.
    public void SelectDayFromMultipleDateCalendar(String day) throws InterruptedException {
        // We are using a special XPath style to select the day of current month.
        // It will ignore the previous or next month day and pick the correct one.
        By calendarXpath = By.xpath("//td[not(contains(@class, 'ui-datepicker-other-month')) and text()='" + day + "']");
        browser.findElement(calendarXpath).click();

        Thread.sleep(2000);
    }

    @AfterTest
    public void endTest() {
        browser.quit();
    }
}
