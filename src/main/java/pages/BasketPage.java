package pages;

import base.DriverFactory;
import org.openqa.selenium.WebElement;
import utils.Assertions;
import utils.ElementUtils;
import utils.WaitUtils;

import static utils.elementStore.BasketElements.*;
import static utils.Assertions.*;

public class BasketPage {

    public void goToBasket() {
        try {
            ElementUtils.clickElement(GO_TO_BASKET_BUTTON);
            System.out.println("🧺 Sepete gidildi.");
        } catch (Exception e) {
            System.out.println("❌ Sepete gidilemedi: " + e.getMessage());
        }
    }

    public void deleteBasketItems() {
        if (ElementUtils.isVisible(DELETE_ITEMS_BUTTON)) {
            ElementUtils.clickElement(DELETE_ITEMS_BUTTON);
            System.out.println("🗑️ Sepet temizlendi.");
        } else {
            System.out.println("🚫 Sepette silinecek ürün bulunamadı.");
        }
    }

    public void verifyProductRemovedMessage() {
        try {
            WaitUtils.waitForPageLoadComplete();
            WebElement messageElement = WaitUtils.waitForVisibility(REMOVE_MESSAGE, 5);
            String message = messageElement.getText();

            verifyTextContains(message, "ürünü sepetinden kaldırıldı");
            System.out.println("✅ Sepetten kaldırıldığı mesajı başarıyla doğrulandı → " + message);

        } catch (Exception e) {
            System.out.println("❌ Sepetten kaldırılma mesajı doğrulanamadı → Hata: " + e.getMessage());
            throw e;
        }
    }
}

