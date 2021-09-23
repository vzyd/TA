import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;


public class SearchTests extends BaseTest {

    @Test(dataProvider = "test-data", dataProviderClass = DataProviders.class)
    public void checkThatSearchResultsContainsSearchWord(String keyWord1, String keyWord2) {
        getHomePage().searchByKeyword(keyWord1);
        getHomePage().waitForPageLoadComplete(30);
        List<WebElement> searchResultsList = getSearchResultsPage().getSearchResultsList();
        for (WebElement element : searchResultsList) {
            assertTrue(element.getText().toUpperCase().contains(keyWord2));
        }
    }
}