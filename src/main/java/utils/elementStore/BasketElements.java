package utils.elementStore;

import org.openqa.selenium.By;

public class BasketElements {

    public static final By GO_TO_BASKET_BUTTON = By.cssSelector("div.go-to-basket-container");
    public static final By APPROVE_SUMMARY_BUTTON = By.cssSelector("div.pb-summary-approve");
    public static final By DELETE_ITEMS_BUTTON = By.xpath("//button[@class='checkout-saving-remove-button']");
    public static final By REMOVE_MESSAGE = By.xpath("//p[contains(normalize-space(.), 'ürünü sepetinden kaldırıldı')]");


}
