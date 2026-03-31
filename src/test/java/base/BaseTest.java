package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import utils.Config;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.util.List;

public class BaseTest {

    protected WebDriver driver;
    @BeforeEach
    public void setUp() {
        String browser = System.getProperty("browser", "firefox").toLowerCase();
        driver = createDriver(browser);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // Lowered implicit wait
        driver.manage().window().maximize();

        driver.get(Config.get("BASE_URL"));


    }

    private WebDriver createDriver(String browser) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return new ChromeDriver(options);
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                return new FirefoxDriver(firefoxOptions);
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                return new EdgeDriver(edgeOptions);
            default:
                throw new IllegalArgumentException("Navegador não suportado: " + browser);
        }
    }

    /**
     * Utility to hide all iframes (e.g., ads) that may block form fields.
     */
    protected void hideObstructingIframes() {
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (WebElement iframe : iframes) {
            try {
                js.executeScript("arguments[0].style.display='none';", iframe);
            } catch (Exception ignored) {}
        }
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        saveScreenshot(testInfo.getDisplayName());
        if (driver != null) {
            try {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0)); // Remove wait before quit
                driver.switchTo().alert().dismiss(); // Dismiss alert if present
            } catch (Exception ignored) {}
            driver.quit();
        }
    }
    @Attachment(value = "Page Screenshot - {name}", type = "image/png")
    public byte[] saveScreenshot(String name) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
