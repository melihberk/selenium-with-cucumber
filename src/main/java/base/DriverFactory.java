package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.ConfigReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;

public class DriverFactory {

    private static final Logger logger = LoggerFactory.getLogger(DriverFactory.class);
    private static WebDriver driver;

    // Ortam bilgisi
    public static String browserName;
    public static String baseUrl;
    public static boolean isFullScreen;
    public static boolean isSafari = false;
    public static boolean zoomCondition = false;
    public static boolean chromeZoomCondition = false;
    public static boolean firefoxZoomCondition = false;

    public static WebDriver getDriver() {

        if (driver == null) {
            try {
                // Konfigürasyonu yükle
                browserName = ConfigReader.getProperty("browser").toLowerCase();
                baseUrl = ConfigReader.getProperty("baseUrl");
                isFullScreen = Boolean.parseBoolean(ConfigReader.getProperty("isFullScreen"));
                String setSizeValue = ConfigReader.getProperty("setSizeValue"); // "1280,720"
                chromeZoomCondition = Boolean.parseBoolean(ConfigReader.getProperty("chromeZoom"));
                firefoxZoomCondition = Boolean.parseBoolean(ConfigReader.getProperty("firefoxZoom"));

                // Driver oluştur
                switch (browserName) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("--no-sandbox");
                        options.addArguments("--disable-dev-shm-usage");
                        options.addArguments("--disable-gpu");
                        options.addArguments("--headless=new"); // Modern headless
                        options.addArguments("--remote-allow-origins=*");
                        driver = new ChromeDriver(options);
                        break;

                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.addArguments("--headless"); // Headless mod (CI için zorunlu)
                        firefoxOptions.addArguments("--disable-gpu");
                        firefoxOptions.addArguments("--no-sandbox");
                        firefoxOptions.addArguments("--disable-dev-shm-usage");
                        driver = new FirefoxDriver(firefoxOptions);
                        break;

                    default:
                        throw new RuntimeException("Geçersiz browser: " + browserName);
                }

                // Genel ayarlar
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

                if (isFullScreen) {
                    driver.manage().window().fullscreen();
                } else {
                    driver.manage().window().maximize();
                }

                // Zoom ayarı durumu setle
                isSafari = browserName.equalsIgnoreCase("safari");
                zoomCondition = (browserName.equalsIgnoreCase("chrome") && chromeZoomCondition)
                        || (browserName.equalsIgnoreCase("firefox") && firefoxZoomCondition);

                // Base URL'e git
                driver.get(baseUrl);

                logger.info("Driver başarıyla başlatıldı → Tarayıcı: {}", browserName);

            } catch (Exception e) {
                logger.error("Driver başlatılamadı: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            logger.info("Driver kapatıldı.");
            driver = null;
        }
    }
}
