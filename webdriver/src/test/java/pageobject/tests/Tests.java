package pageobject.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class Tests extends BaseTest {


    @Test(priority = 1)
    public void checkThatJavaTabSelected() {
        getHomePage().clickOnDocumentationButton();
        getDocumentationPage().clickOnJavaTab();
        getDocumentationPage().waitVisibilityOfElement(30, By.xpath(getDocumentationPage().getJavaCode()));
        assertTrue(getDocumentationPage().isJavaTabSelected());
    }


    @Test(priority = 2)
    public void checkThatPythonTabSelected() {
        getHomePage().clickOnDocumentationButton();
        getDocumentationPage().clickOnPythonTab();
        getDocumentationPage().waitVisibilityOfElement(30, By.xpath(getDocumentationPage().getPythonCode()));
        assertTrue(getDocumentationPage().isPythonTabSelected());
    }

    @Test(priority = 3)
    public void checkThatCSharpTabSelected() {
        getHomePage().clickOnDocumentationButton();
        getDocumentationPage().clickOnCSharpTab();
        getDocumentationPage().waitVisibilityOfElement(30, By.xpath(getDocumentationPage().getCsharpCode()));
        assertTrue(getDocumentationPage().isCSharpTabSelected());
    }

    @Test(priority = 4)
    public void checkThatRubyTabSelected() {
        getHomePage().clickOnDocumentationButton();
        getDocumentationPage().clickOnRubyTab();
        getDocumentationPage().waitVisibilityOfElement(30, By.xpath(getDocumentationPage().getRubyCode()));
        assertTrue(getDocumentationPage().isRubyTabSelected());
    }

    @Test(priority = 5)
    public void checkThatJavaScriptTabSelected() {
        getHomePage().clickOnDocumentationButton();
        getDocumentationPage().clickOnJavaScriptTab();
        getDocumentationPage().waitVisibilityOfElement(30, By.xpath(getDocumentationPage().getJavaScriptCode()));
        assertTrue(getDocumentationPage().isJavaScriptTabSelected());
    }

    @Test(priority = 6)
    public void checkThatKotlinTabSelected() {
        getHomePage().clickOnDocumentationButton();
        getDocumentationPage().clickOnKotlinTab();
        getDocumentationPage().waitVisibilityOfElement(60, By.xpath(getDocumentationPage().getKotlinCode()));
        assertTrue(getDocumentationPage().isKotlinTabSelected());
    }

}
