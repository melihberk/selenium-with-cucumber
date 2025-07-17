package stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import utils.Assertions;
import base.DriverFactory;
import utils.ElementUtils;

import static utils.elementStore.BasketElements.*;
import static utils.elementStore.ProductElements.*;

public class AssertSteps {

    @Then("URL {string} içermelidir")
    public void url_icermeli(String expectedFragment) {
        Assertions.verifyUrlContains(DriverFactory.getDriver(), expectedFragment);
    }

    @Then("{string} elementi görünür olmalıdır")
    public void elementi_gorunur_olmalidir(String elementKey) {
        By locator = getLocatorByKey(elementKey);
        boolean visible = ElementUtils.isVisible(locator);
        if (!visible) {
            throw new AssertionError("❌ '" + elementKey + "' elementi görünür değil!");
        }
        System.out.println("✅ '" + elementKey + "' elementi başarıyla doğrulandı.");
    }

    private By getLocatorByKey(String key) {
        switch (key.toLowerCase()) {
            case "ürün başlığı":
                return PRODUCT_TITLE;
            case "sepeti onayla butonu":
                return APPROVE_SUMMARY_BUTTON;
            case "sepete ekle butonu":
                return ADD_TO_CART_BUTTON;
            case "konum bilgilendirme kapatma":
                return LOCATION_INFO_CLOSE_BUTTON;
            default:
                throw new IllegalArgumentException("Tanımsız element anahtarı: " + key);
        }
    }
}
