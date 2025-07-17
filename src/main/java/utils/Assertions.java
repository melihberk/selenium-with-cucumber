package utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Assertions {

    public static void verifyUrlContains(WebDriver driver, String expectedFragment) {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(
                "❌ URL doğrulaması başarısız! Beklenen: " + expectedFragment + " | Gerçek: " + currentUrl,
                currentUrl.contains(expectedFragment)
        );
        System.out.println("✅ URL doğrulaması başarılı: " + currentUrl);
        WaitUtils.waitForPageLoadComplete();
    }

    public static void verifyTextContains(String actual, String expected) {
        Assert.assertTrue("Metin doğrulaması başarısız! Beklenen içerik: " + expected +
                " | Gerçek metin: " + actual, actual.contains(expected));
    }

    public static void verifyElementVisible(By locator, String elementName) {
        try {
            WebElement element = WaitUtils.waitForVisibility(locator, 5);
            Assert.assertTrue("❌ " + elementName + " görünür değil!", element.isDisplayed());
            System.out.println("✅ " + elementName + " görünür.");
        } catch (Exception e) {
            throw new AssertionError("❌ " + elementName + " görünür değil veya bulunamadı!", e);
        }
    }
}
