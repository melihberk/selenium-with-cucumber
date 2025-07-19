package hooks;

import base.DriverFactory;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {

    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void setUp() {
        logger.info("🟢 Test başlatılıyor...");
        DriverFactory.getDriver(); // Driver başlatılıyor
    }

    @AfterStep
    public void afterEachStep(Scenario scenario) {
        try {
            byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Adım Ekran Görüntüsü");
            logger.info("📸 Screenshot alındı: {}", scenario.getName());
        } catch (Exception e) {
            logger.error("❌ Screenshot alınamadı: {}", e.getMessage());
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Hata Anı Ekran Görüntüsü");
            logger.error("🔴 Test başarısız: {}", scenario.getName());
        } else {
            logger.info("✅ Test başarılı: {}", scenario.getName());
        }

        boolean KEEP_BROWSER_OPEN = false;
        if (!KEEP_BROWSER_OPEN) {
            DriverFactory.quitDriver();
        } else {
            logger.info("🟡 Tarayıcı açık bırakıldı (debug amaçlı).");
        }
    }
}
