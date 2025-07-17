package pages;

import base.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class AssertPage {

    WebDriver driver = DriverFactory.getDriver();

    public void verifyUrlContains(String expectedFragment) {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(
                "URL doğrulaması başarısız! Beklenen içerik: " + expectedFragment + " | Gerçek URL: " + currentUrl,
                currentUrl.contains(expectedFragment)
        );
    }

    public void verifyTextContains(String actual, String expected) {
        Assert.assertTrue(
                "Metin doğrulaması başarısız! Beklenen içerik: " + expected + " | Gerçek metin: " + actual,
                actual.contains(expected)
        );
    }

    // Gerekirse ileride element doğrulama, görünürlük kontrolü gibi metotlar da buraya eklenebilir
}
