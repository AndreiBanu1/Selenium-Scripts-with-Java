import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleCountResults {
    WebDriver driver = new ChromeDriver();

    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/banuandreicristian/Documents/WebDrivers/chromedriver/chromedriver");

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        WebDriver driver = new ChromeDriver(options);

        driver.wait(3000);
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
    }

    public void acceptCookies() {
        try {
            WebElement acceptAllButton = driver.findElement(By.xpath("//button[contains(text(), 'Accept All')]"));
            acceptAllButton.click();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public boolean test_search_by_text() {
        WebElement search_field = driver.findElement(By.className("q"));
        search_field.sendKeys("Selenium WebDriver Interview Question");
        search_field.submit();

        WebElement lists = driver.findElement(By.className("r"));
        int no = Integer.parseInt(String.valueOf(lists));
        return no == 17;
    }
}
