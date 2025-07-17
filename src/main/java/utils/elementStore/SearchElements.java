package utils.elementStore;

import org.openqa.selenium.By;

public class SearchElements {

    // Kategori filtreleri (dinamik olarak text'e göre filtre seçimi yapılacak)
    public static By getCategoryFilter(String categoryName) {
        return By.xpath("//div[@class='fltr-item-text' and contains(text(), '" + categoryName + "')]");
    }

    // Yüksek puanlı ürünler
    public static final By HIGH_RATED_FILTER_BUTTON = By.cssSelector("button.quick-filters-item.productRating");

    // Tüm ürün kartları
    public static final By PRODUCT_CARDS = By.cssSelector("div.p-card-wrppr.with-campaign-view");

}
