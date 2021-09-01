package pageobject.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Tests extends BaseTest {

//    private String SEARCH_KEYWORD = "iPhone 11";
//    private String EXPECTED_SEARCH_QUERY = "query=iPhone";

//    @Test(priority = 1)
//    public void checkThatUrlContainsSearchWord() {
//        getHomePage().searchByKeyword(SEARCH_KEYWORD);
//        assertTrue(getDriver().getCurrentUrl().contains(EXPECTED_SEARCH_QUERY));
//    }
//
//    @Test(priority = 2)
//    public void checkElementsAmountOnSearchPage() {
//        getHomePage().searchByKeyword(SEARCH_KEYWORD);
//        getHomePage().implicitWait(30);
//        assertEquals(getSearchResultsPage().getSearchResultsCount(), 12);
//    }

    @Test(priority = 1)
    public void checkThatJavaTabSelected() {
        getHomePage().clickOnDocumentationButton();

        getDocumentationPage().clickOnJavaTab();

        assertTrue(getDocumentationPage().getTextFromJavaCode().contains("java"));

    }

    @Test(priority = 2)
    public void checkThatPythonTabSelected() {
        getHomePage().clickOnDocumentationButton();
        getDocumentationPage().clickOnPythonTab();
        getDocumentationPage().implicitWait(60);
        assertTrue(getDocumentationPage().getTextFromPythonCode().contains("example"));

    }
}
