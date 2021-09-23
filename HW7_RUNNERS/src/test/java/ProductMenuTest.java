import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ProductMenuTest extends BaseTest {
    private String NAME_MENU = "Каталог товаров";

    @Test
    public void checkThatHomePageContainsProductsMenu() {
        getHomePage().getTextOfProductMenu();
        assertTrue(getHomePage().getTextOfProductMenu().contains(NAME_MENU));
    }
}
