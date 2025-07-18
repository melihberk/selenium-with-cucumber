package stepDefinitions;

import base.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;
import utils.ExcelUtils;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @Given("Kullanıcı ana sayfaya gider ve çerezleri kabul eder")
    public void kullanici_trendyol_sayfasina_gider() {
        DriverFactory.getDriver();
        homePage.acceptCookiesIfPresent();
    }

    @And("Anasayfada cinsiyet seçimi olarak {string} seçilir")
    public void anasaydada_cinsiyet_secimi_yapilir(String gender) {
        homePage.selectGender(gender);
    }

    @When("Searchbox'a {string} yazılıp enter tuşuna basılır")
    public void searchboxa_string_yazilip_enter_tusuna_basilir(String keyword) {
        homePage.searchForWithEnter(keyword);
    }

    @When("Excel dosyasından alınan kelime Searchbox'a yazılır ve enter tuşuna basılır")
    public void exceldenKelimeAlVeSearchEt() {
        String kelime = ExcelUtils.getCellValue("src/test/resources/data.xlsx", "Sheet1", 0, 0);
        HomePage homePage = new HomePage();
        homePage.searchForWithEnter(kelime);
    }

}
