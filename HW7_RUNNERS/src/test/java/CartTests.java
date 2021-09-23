import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartTests extends BaseTest {

    private String EXPECTED_AMOUNT_OF_PRODUCTS_IN_CART_1 = "1";
    private String EXPECTED_AMOUNT_OF_PRODUCTS_IN_CART_0 = "0";

    @Test(priority = 1)
    public void checkAddToCart() {
        getHomePage().clickOnProductCatalogButton();
        getHomePage().clickOnTvAccessoriesStoreButton();
        getTvAccessoriesPage().clickOnTvButton();
        getTvPage().waitForPageLoadComplete(30);
        getTvPage().clickOnAddToCartButton();
        getTvPage().waitVisibilityOfElement(30, getTvPage().getAddToCartPopup());
        getTvPage().clickOnContinueShoppingButton();
        getTvPage().waitVisibilityOfElement(3, getHomePage().getProductsInCartIcon());
        assertEquals(getHomePage().getTextOfAmountProductsInCart(), EXPECTED_AMOUNT_OF_PRODUCTS_IN_CART_1);
    }

    @Test(priority = 2)
    public void checkDeleteFromCart() {
        //add to cart
        getHomePage().clickOnProductCatalogButton();
        getHomePage().clickOnTvAccessoriesStoreButton();
        getTvAccessoriesPage().clickOnTvButton();
        getTvPage().waitForPageLoadComplete(30);
        getTvPage().clickOnAddToCartButton();
        getTvPage().waitVisibilityOfElement(30, getTvPage().getAddToCartPopup());
        getTvPage().clickOnContinueShoppingButton();
        getTvPage().waitVisibilityOfElement(3, getHomePage().getProductsInCartIcon());

        //delete from cart
        getTvPage().clickOnCartButton();
        getTvPage().waitVisibilityOfElement(30, getTvPage().getAddToCartPopup());
        getTvPage().clickOnDellProductFromCartButton();
        getTvPage().implicitWait(30);
        assertEquals(getHomePage().getTextOfAmountProductsInCart(), EXPECTED_AMOUNT_OF_PRODUCTS_IN_CART_0);

    }
}
