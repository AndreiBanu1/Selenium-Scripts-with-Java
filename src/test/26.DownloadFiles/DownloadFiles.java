import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DownloadFileExample {
    public static void main(String[] args) {
        try {
            FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("browser.download.folderList", 2);
            profile.setPreference("browser.download.managerShowWhenStarting", false);
            profile.setPreference("browser.download.dir", "C:/Users/HP/Desktop");
            profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream,application/zip");

            WebDriver driver = new FirefoxDriver(profile);
            driver.get("https://www.selenium.dev/downloads/");
            driver.findElement(By.xpath("")).click();

            System.out.println("Downloaded Successfully");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
