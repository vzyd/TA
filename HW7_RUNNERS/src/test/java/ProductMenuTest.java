
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class ProductMenuTest extends BaseTest {


        @Test(dataProvider = "json-data", dataProviderClass=DataProviders.class)
        public void checkThatHomePageContainsProductsMenu (String productName){
            WebElement productMenu;
            getHomePage().clickOnProductCatalogButton();
            productMenu = getHomePage().getProductsMenu();
            getHomePage().waitVisibilityOfElement(30, productMenu);
            assertTrue(productMenu.getText().contains(productName));
        }
    }

