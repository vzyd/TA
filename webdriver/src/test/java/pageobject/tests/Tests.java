package pageobject.tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class Tests extends BaseTest {


    @Test(priority = 1)
    public void checkThatJavaTabSelected() {
        getHomePage().clickOnDocumentationButton();
        getDocumentationPage().clickOnJavaTab();
        assertTrue(getDocumentationPage().isJavaTabSelected());
    }


    @Test(priority = 2)
    public void checkThatPythonTabSelected() {
        getHomePage().clickOnDocumentationButton();
        getDocumentationPage().clickOnPythonTab();
        assertTrue(getDocumentationPage().isPythonTabSelected());
    }

    @Test(priority = 3)
    public void checkThatCSharpTabSelected() {
        getHomePage().clickOnDocumentationButton();
        getDocumentationPage().clickOnCSharpTab();
        assertTrue(getDocumentationPage().isCSharpTabSelected());
    }

    @Test(priority = 4)
    public void checkThatRubyTabSelected() {
        getHomePage().clickOnDocumentationButton();
        getDocumentationPage().clickOnRubyTab();
        assertTrue(getDocumentationPage().isRubyTabSelected());
    }

    @Test(priority = 5)
    public void checkThatJavaScriptTabSelected() {
        getHomePage().clickOnDocumentationButton();
        getDocumentationPage().clickOnJavaScriptTab();
        assertTrue(getDocumentationPage().isJavaScriptTabSelected());
    }

    @Test(priority = 6)
    public void checkThatKotlinTabSelected() {
        getHomePage().clickOnDocumentationButton();
        getDocumentationPage().clickOnKotlinTab();
        assertTrue(getDocumentationPage().isKotlinTabSelected());
    }

}
