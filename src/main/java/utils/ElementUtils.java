package utils;

import base.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ElementUtils {

    private static final int TIMEOUT = 10;

    private static WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    private static WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(TIMEOUT));
    }

    // ✅ Elemente tıkla
    public static void clickElement(By locator) {
        try {
            WebElement element = getWait().until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
            System.out.println("✅ Tıklandı: " + locator);
        } catch (ElementClickInterceptedException e) {
            System.out.println("⚠️ Normal tıklama başarısız, JS ile deneniyor: " + locator);
            clickElementJs(locator);
        } catch (Exception e) {
            System.out.println("❌ Elemente tıklanamadı: " + locator + " Hata: " + e.getMessage());
            throw e;
        }
    }

    // ✅ JS ile tıklama
    public static void clickElementJs(By locator) {
        WebElement element = getDriver().findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    // ✅ Element görünür mü
    public static boolean isVisible(By locator) {
        try {
            getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
            System.out.println("👀 Element görünür: " + locator);
            return true;
        } catch (TimeoutException e) {
            System.out.println("🚫 Element görünmedi: " + locator);
            return false;
        }
    }

    // ✅ Element görünmüyor mu
    public static boolean isNotVisible(By locator) {
        try {
            getWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
            System.out.println("🫥 Element artık görünmüyor: " + locator);
            return true;
        } catch (TimeoutException e) {
            System.out.println("❗ Element hâlâ görünüyor: " + locator);
            return false;
        }
    }

    // ✅ Sayfada elemente scroll
    public static void scrollTo(By locator) {
        WebElement element = getDriver().findElement(locator);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        System.out.println("🧭 Scroll edildi → " + locator);
    }

    public static List<WebElement> findAll(By locator) {
        return getDriver().findElements(locator);
    }

    public static void switchToLastTab() {
        WebDriver driver = DriverFactory.getDriver();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        System.out.println("🪟 Yeni sekmeye geçildi.");
    }


}
