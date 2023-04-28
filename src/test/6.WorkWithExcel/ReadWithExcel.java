import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://www.facebook.com/");

        String path = "E:\\data\\data.xlsx";
        XSSFWorkbook workbook = new XSSFWorkbook(Files.newInputStream(Paths.get(path)));
        Sheet sheet = workbook.getSheet("Sheet1");
        int rows = sheet.getPhysicalNumberOfRows();

        for (int r = 1; r < rows; r++) {
            Row row = sheet.getRow(r);
            Cell usernameCell = row.getCell(0);
            Cell passwordCell = row.getCell(1);
            String username = usernameCell.getStringCellValue();
            String password = passwordCell.getStringCellValue();
            System.out.println(username);
            System.out.println(password);
            driver.findElement(By.id("email")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.id("btn")).click();
        }

        driver.quit();
    }
}
