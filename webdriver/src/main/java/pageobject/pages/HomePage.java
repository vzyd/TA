package pageobject.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class HomePage extends BasePage {

    private static final String DOCUMENTATION_BUTTON = "//a[@href='/documentation']";
//    private static final String PRODUCT_CATALOG_BUTTON = "//span[@class='sidebar-item']";
//    private static final String APPLE_STORE_BUTTON = "//ul[contains(@class,'sidebar-list')]//a[contains(@href, 'apple-store')]";
//    private static final String AMOUNT_OF_PRODUCTS_IN_CART = "//div[contains(@class,'header-bottom__cart')]//div[contains(@class,'cart_count')]";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnDocumentationButton() {
        driver.findElement(xpath(DOCUMENTATION_BUTTON)).click();
    }

}
