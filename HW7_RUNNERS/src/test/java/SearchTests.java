import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SearchTests extends BaseTest {

    private String SEARCH_KEYWORD = "tv";
    private String TEXT_IN_WEBELEMENTS = "TV";

    @DataProvider(name = "test-data")
    public Object[][] dataProvFunc(){
        return new Object[][]{
                {"tv","TV"},{"iphone","iPhone"}
        };
    }


    @Test(dataProvider = "test-data")
    public void checkThatSearchResultsContainsSearchWord(String keyWord1, String keyWord2) {
        getHomePage().searchByKeyword(keyWord1);
        for (WebElement webElement : getSearchResultsPage().getSearchResultsList()) {
            assertTrue(webElement.getText().contains(keyWord2));
        }
    }
}