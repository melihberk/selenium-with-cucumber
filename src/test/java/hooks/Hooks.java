package hooks;

import base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {

    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void setUp() {
        logger.info("🟢 Test başlatılıyor...");
        DriverFactory.getDriver(); // Driver başlatılıyor
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

        // 👇 Tarayıcı açık kalsın mı? true ise kapatma
        boolean KEEP_BROWSER_OPEN = false;
        if (!KEEP_BROWSER_OPEN) {
            DriverFactory.quitDriver();
        } else {
            logger.info("🟡 Tarayıcı açık bırakıldı (debug amaçlı).");
        }
    }

}
