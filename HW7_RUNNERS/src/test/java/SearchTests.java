import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SearchTests extends BaseTest {

    private String SEARCH_KEYWORD = "tv";
    private String TEXT_IN_WEBELEMENTS = "TV";


    @Test
    public void checkThatSearchResultsContainsSearchWord() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        for (WebElement webElement : getSearchResultsPage().getSearchResultsList()) {
            assertTrue(webElement.getText().contains(TEXT_IN_WEBELEMENTS));
        }
    }
}