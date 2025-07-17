package utils.elementStore;

import org.openqa.selenium.By;

public class ProductElements {

    public static final By LOCATION_INFO_CLOSE_BUTTON = By.cssSelector("button.onboarding__default-renderer-primary-button");
    public static final By ADD_TO_CART_BUTTON = By.xpath("//span[contains(@class, 'add-to-cart-button')]");
    public static final By PRODUCT_TITLE = By.cssSelector("h1[data-testid='product-title']");
}
