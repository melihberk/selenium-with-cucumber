package pages;

import utils.ElementUtils;
import utils.WaitUtils;

import static utils.elementStore.ProductElements.*;

public class ProductPage {

    public void closeLocationInfoIfPresent() {
        WaitUtils.waitForPageLoadComplete(); // Sayfanın tamamen yüklenmesini bekle
        ElementUtils.switchToLastTab();
        WaitUtils.waitForPageLoadComplete();

        if (ElementUtils.isVisible(LOCATION_INFO_CLOSE_BUTTON)) {
            ElementUtils.clickElement(LOCATION_INFO_CLOSE_BUTTON);
            System.out.println("📍 Konum bilgilendirme mesajı kapatıldı.");
        } else {
            System.out.println("ℹ️ Konum bilgilendirme mesajı görünmedi.");
        }
    }

    public void clickAddToCart() {
        try {
            ElementUtils.clickElement(ADD_TO_CART_BUTTON);
            System.out.println("🛒 Sepete ekle butonuna tıklandı.");
        } catch (Exception e) {
            System.out.println("❌ Sepete ekle butonuna tıklanamadı: " + e.getMessage());
        }
    }


}
