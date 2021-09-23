import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@id='input_search']")
    private WebElement searchInput;

    @FindBy(xpath = "//span[@class='sidebar-item']")
    private WebElement productCatalogButton;

    @FindBy(xpath = "//ul[contains(@class,'sidebar-list')]//a[contains(@href, 'televizory-i-aksessuary1')]")
    private WebElement tvAccessoriesStoreButton;

    @FindBy(xpath = "//div[contains(@class,'header-bottom__cart')]//div[contains(@class,'cart_count')]")
    private WebElement amountOfProductsInCart;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchByKeyword(final String keyword) {
        searchInput.sendKeys(keyword, Keys.ENTER);
    }

    public void clickOnProductCatalogButton() {
        productCatalogButton.click();
    }

    public void clickOnTvAccessoriesStoreButton() {
        tvAccessoriesStoreButton.click();
    }


    public String getTextOfAmountProductsInCart() {
        return amountOfProductsInCart.getText();
    }

    public WebElement getProductsInCartIcon() {
        return amountOfProductsInCart;
    }

    public String getTextOfProductMenu() {
        return productCatalogButton.getText();
    }

}