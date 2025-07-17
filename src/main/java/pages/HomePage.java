package pages;

import base.DriverFactory;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;
import utils.ExcelUtils;


import static utils.elementStore.HomeElements.*;



public class HomePage {

    private WebDriver driver = DriverFactory.getDriver();

    public void goToHomePage() {
        driver.get(HOME_URL);
        WaitUtils.waitForPageLoadComplete();
    }

    public void acceptCookiesIfPresent() {
        try {
            WebElement cookieBtn = WaitUtils.waitForVisibility(COOKIE_ACCEPT_BUTTON, 3);
            if (cookieBtn.isDisplayed()) {
                cookieBtn.click();
                System.out.println("✅ Çerezler kabul edildi.");
            }
        } catch (Exception e) {
            System.out.println("🔎 Çerez popup görünmedi veya zamanında yüklenmedi.");
        }
    }

    public void searchForWithEnter(String keyword) {
        try {
            WebElement searchBox = WaitUtils.waitForVisibility(SEARCH_INPUT, 5);
            searchBox.clear();
            System.out.println("📝 Searchbox'a yazılıyor: " + keyword);
            searchBox.sendKeys(keyword);
            Thread.sleep(500); // debounce ihtimali için
            searchBox.sendKeys(Keys.ENTER);
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("🔴 Arama kutusuna yazı yazılırken hata oluştu: " + e.getMessage());
        }
    }


    public void selectGender(String gender) {
        try {
            WebElement button = gender.equalsIgnoreCase("kadın")
                    ? WaitUtils.waitForVisibility(KADIN_BUTTON, 5)
                    : WaitUtils.waitForVisibility(ERKEK_BUTTON, 5);
            button.click();
        } catch (Exception e) {
            System.out.println("❗ Cinsiyet popup'ı görünmedi veya buton bulunamadı.");
        }
    }
}
