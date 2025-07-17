package pages;

import org.openqa.selenium.WebElement;
import utils.ElementUtils;
import utils.WaitUtils;

import java.util.List;
import java.util.Random;

import static utils.elementStore.SearchElements.*; // 🧠 Static import

public class SearchResultsPage {

    // === ACTIONS =====================================
    public void selectCategoryFilter(String categoryName) {
        try {
            ElementUtils.clickElement(getCategoryFilter(categoryName));
            System.out.println("✅ '" + categoryName + "' filtresi seçildi.");
        } catch (Exception e) {
            System.out.println("🔴 '" + categoryName + "' filtresi seçilemedi: " + e.getMessage());
        }
    }

    public void clickHighRatedProducts() {
        try {
            ElementUtils.clickElement(HIGH_RATED_FILTER_BUTTON);
            System.out.println("⭐ Yüksek puanlı ürünler filtresi tıklandı.");
        } catch (Exception e) {
            System.out.println("❌ Yüksek puanlı ürünler filtresi tıklanamadı: " + e.getMessage());
        }
    }

    public void selectRandomProduct() {
        try {
            WaitUtils.waitForPageLoadComplete(); // Sayfa yüklemesini bekle
            List<WebElement> productList = ElementUtils.findAll(PRODUCT_CARDS);
            int productCount = productList.size();

            if (productCount == 0) {
                System.out.println("❌ Ürün bulunamadı.");
                return;
            }

            int randomIndex = new Random().nextInt(productCount);
            WebElement randomProduct = productList.get(randomIndex);
            System.out.println("🎯 Rastgele ürün seçildi: index = " + randomIndex);
            randomProduct.click();
            //ElementUtils.clickElement(PRODUCT_CARDS);

        } catch (Exception e) {
            System.out.println("🔴 Ürün seçimi sırasında hata oluştu: " + e.getMessage());
        }
    }

}
