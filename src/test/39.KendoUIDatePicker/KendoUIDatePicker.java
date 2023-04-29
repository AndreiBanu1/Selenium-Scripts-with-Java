import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KendoUI_Date_Picker {
    private String demosite = "https://demos.telerik.com/kendo-ui/datetimepicker/index";

    WebDriver browser;
    WebDriverWait wait;

    @BeforeTest
    public void startTest() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        browser = new ChromeDriver();
        browser.navigate().to(demosite);
        browser.manage().window().maximize();
    }

    @Test
    public void SelectDateFromKendoCalendar() throws InterruptedException {
        // click to open the date time picker calendar.
        WebElement kendodtp = browser.findElement(By.cssSelector(".k-icon.k-i-calendar"));
        kendodtp.click();

        // Provide the day of the month to select the date.
        HandleKendoDateTimePicker("11");
    }

    //Function to select the day of the month in the date time picker.
    public void HandleKendoDateTimePicker(String day) throws InterruptedException {
        Thread.sleep(5000);
        WebElement table = browser.findElement(By.className("k-content"));
        System.out.println("Kendo Calendar");
        List<WebElement> tableRows = table.findElements(By.xpath("//tr"));
        for (WebElement row : tableRows) {
            List<WebElement> cells = row.findElements(By.xpath("td"));
            for (WebElement cell : cells) {
                if (cell.getText().equals(day)) {
                    browser.findElement(By.linkText(day)).click();
                }
            }
        }
        Thread.sleep(2000);
    }

    @AfterTest
    public void endTest() {
        browser.quit();
    }
}
