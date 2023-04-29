import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Broken_Images {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:5000/images");
        driver.manage().window().maximize();

        List<WebElement> list = driver.findElements(By.tagName("img"));
        System.out.println("Total number of Images on webpage: ----››" + list.size());

        for (WebElement ele : list) {
            try {
                HttpURLConnection conn = (HttpURLConnection) new URL(ele.getAttribute("src")).openConnection();
                conn.setRequestMethod("GET");
                int responseCode = conn.getResponseCode();
                if (responseCode != 200) {
                    System.out.println("Broken Image:---->>" + ele.getAttribute("src"));
                } else {
                    System.out.println("Fine Image:------->" +ele.getAttribute("src"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        driver.quit();
    }
}
