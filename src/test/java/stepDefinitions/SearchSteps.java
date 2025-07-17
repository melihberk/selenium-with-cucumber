package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.SearchResultsPage;
import utils.ExcelUtils;

public class SearchSteps {

    SearchResultsPage searchResultsPage = new SearchResultsPage();

    @And("Kategorilerden {string} filtresi seçilir")
    public void kategorilerden_filtresi_secilir(String kategori) {
        searchResultsPage.selectCategoryFilter(kategori);
    }

    @And("Yüksek puanlı ürünler filtresi tıklanır")
    public void yuksek_puanli_urunler_filtresi_tiklanir() {
        searchResultsPage.clickHighRatedProducts();
    }

    @And("Listelenen ürünlerden rastgele biri seçilir")
    public void rastgele_urun_secilir() {
        searchResultsPage.selectRandomProduct();
    }



}
