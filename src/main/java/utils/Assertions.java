package utils;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;


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
}
