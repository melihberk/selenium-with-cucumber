package utils;

import base.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class WaitUtils {

    private static final Logger logger = LoggerFactory.getLogger(WaitUtils.class);
    private static final int DEFAULT_TIMEOUT = 20;

    private static WebDriverWait getWait() {
        return new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT));
    }

    public static WebElement waitForVisibility(By locator, int i) {
        logger.info("⏳ Element visibility bekleniyor: " + locator);
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickability(By locator) {
        logger.info("⏳ Element clickable bekleniyor: " + locator);
        return getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static boolean waitForText(By locator, String expectedText) {
        logger.info("⏳ Element içinde metin bekleniyor: " + expectedText);
        return getWait().until(ExpectedConditions.textToBePresentInElementLocated(locator, expectedText));
    }

    public static boolean waitForInvisibility(By locator) {
        logger.info("⏳ Elementin yok olması bekleniyor: " + locator);
        return getWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void waitForUrlToContain(String partialUrl) {
        logger.info("⏳ URL içinde '{}' kelimesi bekleniyor", partialUrl);
        getWait().until(ExpectedConditions.urlContains(partialUrl));
    }

    public static void waitForPageLoadComplete() {
        logger.info("⏳ Sayfa tam yüklenmesi bekleniyor (document.readyState)");
        getWait().until(driver -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState").equals("complete"));
    }

    public static void sleepSeconds(int seconds) {
        try {
            logger.info("😴 Bekleniyor: {} saniye", seconds);
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.warn("❗ Uyku bölündü: " + e.getMessage());
        }
    }
}
