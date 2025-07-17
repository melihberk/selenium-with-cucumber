package stepDefinitions;

import io.cucumber.java.en.And;
import pages.ProductPage;

public class ProductSteps {

    ProductPage productPage = new ProductPage();

    @And("Konum seç bilgilendirme mesajı kapatılır")
    public void konum_sec_bilgilendirme_mesaji_kapatilir() {
        productPage.closeLocationInfoIfPresent();
    }

    @And("Sepete ekle butonuna tıklanır")
    public void sepete_ekle_butonuna_tiklanir() {
        productPage.clickAddToCart();
    }

}
