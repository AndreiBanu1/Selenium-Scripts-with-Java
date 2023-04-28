import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

public class ReadDataFromExcel {

    public static void main(String[] args) throws IOException {
        String path = "E:\\data\\data.xlsx";
        String sheetName = "Sheet1";
        int rowCount = getRowCount(path, sheetName);
        for (int i = 2; i <= rowCount; i++) {
            String username = readData(path, sheetName, i, 1);
            String password = readData(path, sheetName, i, 2);
            System.out.println(username);
            System.out.println(password);
            ChromeDriverService service = new ChromeDriverService.Builder().usingAnyFreePort().build();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            WebDriver driver = new ChromeDriver(service, options);
            driver.get("https://www.facebook.com/");
            WebElement email = driver.findElement(By.id("email"));
            WebElement pass = driver.findElement(By.id("pass"));
            email.sendKeys(username);
            pass.sendKeys(password);
            driver.findElement(By.id("loginbutton")).click();
            driver.quit();
        }
    }

    public static int getRowCount(String file, String sheetName) throws IOException {
        FileInputStream inputStream = new FileInputStream(new File(file));
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum() + 1;
        workbook.close();
        return rowCount;
    }

    public static String readData(String file, String sheetName, int rowNum, int columnNum) throws IOException {
        FileInputStream inputStream = new FileInputStream(new File(file));
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNum - 1);
        Cell cell = row.getCell(columnNum - 1);
        String cellValue = "";
        if (cell.getCellType() == CellType.STRING) {
            cellValue = cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            cellValue =
