import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TvPage extends BasePage {

    @FindBy(xpath = "//a[@class='prod-cart__buy']")
    private List<WebElement> addToCartButton;

    @FindBy(id = "js_cart")
    private WebElement addToCartPopup;

    @FindBy(xpath = "//div[@class='btns-cart-holder']//a[contains(@class,'btn--orange')]")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//div[contains(@class,'header-bottom__cart')]//div[contains(@class, 'cart-item js_cart_count')]")
    private WebElement cartButton;

    @FindBy(xpath = "//div[@class='item']//i[@class='icon icon-close js-btn-close']")
    private WebElement dellProductFromCartButton;


    public TvPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddToCartButton() {
        addToCartButton.get(0).click();
    }

    public void clickOnContinueShoppingButton() {
        continueShoppingButton.click();
    }

    public void clickOnCartButton() {
        cartButton.click();
    }

    public void clickOnDellProductFromCartButton() {
        dellProductFromCartButton.click();
    }


    public WebElement getAddToCartPopup() {
        return addToCartPopup;
    }
}
