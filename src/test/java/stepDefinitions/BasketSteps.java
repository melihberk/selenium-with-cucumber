package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.BasketPage;

public class BasketSteps {

    BasketPage basketPage = new BasketPage();

    @And("Sepete gidilir")
    public void sepete_gidilir() {
        basketPage.goToBasket();
    }

    @And("Sil butonuna tıklanarak sepet temizlenir")
    public void sepet_temizlenir() {
        basketPage.deleteBasketItems();
    }

    @Then("Ürünün sepetten kaldırıldığı mesajı görünür olmalıdır")
    public void urun_sepetten_kaldirildi_mesaji_dogrulanir() {
        new BasketPage().verifyProductRemovedMessage();
    }


}
