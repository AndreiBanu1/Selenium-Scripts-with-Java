import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class CropImage {
    public static void main(String[] args) {
        String driverPath = "/Users/banuandreicristian/Documents/WebDrivers/geckodriver/geckodriver";
        System.setProperty("webdriver.gecko.driver", driverPath);

        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("security.sandbox.content.level", 5);
        options.setProfile(profile);

        WebDriver driver = new FirefoxDriver(options);
        driver.get("https://www.google.com/");

        WebElement element = driver.findElement(By.xpath("//*[@id=\"hplogo\"]"));
        org.openqa.selenium.Point location = element.getLocation();
        org.openqa.selenium.Dimension size = element.getSize();
        byte[] screenshot = ((FirefoxDriver) driver).getScreenshotAs(OutputType.BYTES);
        driver.quit();

        ByteArrayInputStream imageStream = new ByteArrayInputStream(screenshot);
        BufferedImage fullImage = null;
        try {
            fullImage = ImageIO.read(imageStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int left = location.getX();
        int top = location.getY();
        int right = location.getX() + size.getWidth();
        int bottom = location.getY() + size.getHeight();

        BufferedImage croppedImage = fullImage.getSubimage(left, top, right - left, bottom - top);
        File outputFile = new File("screenshot.png");
        try {
            ImageIO.write(croppedImage, "png", outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
