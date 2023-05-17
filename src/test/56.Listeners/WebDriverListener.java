import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WebDriverListenerExample {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
        WebDriverEventListener listener = new WebDriverEventListener();
        eventDriver.register(listener);

        eventDriver.get("https://www.google.com");
        WebElement searchBox = eventDriver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        searchBox.submit();

        eventDriver.quit();
    }
}

class WebDriverEventListener extends AbstractWebDriverEventListener {
    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Before navigating to: " + url);
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("After navigating to: " + url);
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Before finding element: " + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("After finding element: " + by);
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("Before clicking on element: " + element);
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("After clicking on element: " + element);
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        System.out.println("Exception occurred: " + throwable.getMessage());
    }
}
