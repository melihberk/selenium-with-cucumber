package utils.elementStore;

import org.openqa.selenium.By;

public class HomeElements {

    public static final String HOME_URL = "https://www.trendyol.com";

    // Cinsiyet seçim popup
    public static final By GENDER_POPUP_CONTAINER = By.className("homepage-popup-content-container");
    public static final By KADIN_BUTTON = By.xpath("//span[text()='KADIN']/parent::a");
    public static final By ERKEK_BUTTON = By.xpath("//span[text()='ERKEK']/parent::a");

    // Searchbox
    public static final By SEARCH_INPUT = By.cssSelector("input[data-testid='suggestion']");

    // Cookie
    public static final By COOKIE_ACCEPT_BUTTON = By.id("onetrust-accept-btn-handler");

}
