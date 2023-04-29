import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfReader {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // to run the browser in headless mode
        driver = new ChromeDriver(options);
    }

    @Test
    public void printPdfText() throws IOException {
        String url = "https://file-examples.com/wp-content/uploads/2017/10/file-sample_150kB.pdf";
        driver.get(url);
        String output = null;
        URL urlOfPdf = new URL(url);
        try (PDDocument document = PDDocument.load(urlOfPdf.openStream())) {
            output = new PDFTextStripper().getText(document);
        }
        System.out.println("PDF Content: " + output);
    }
}
