package pageobject.tests;

import com.codeborne.selenide.CollectionCondition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;
import static org.testng.Assert.assertTrue;

public class Tests extends BaseTest {
    private static final String JAVA_KEY_WORD = "public";
    private static final String PYTHON_KEY_WORD = "from";
    private static final String CSHARP_KEY_WORD = "using";
    private static final String RUBY_KEY_WORD = "begin";
    private static final String JAVA_SCRIPT_KEY_WORD = "async";
    private static final String KOTLIN_KEY_WORD = "fun";

    @Test(priority = 1)
    public void checkThatJavaTabSelected() {
        getHomePage().clickOnDocumentationButton();
        getDocumentationPage().clickOnJavaTab();
        $$(By.xpath("//code[@class='language-Java']//span")).shouldHave(CollectionCondition.exactTexts(JAVA_KEY_WORD));
    //    assertTrue(getDocumentationPage().isJavaTabSelected());
    }


//    @Test(priority = 2)
//    public void checkThatPythonTabSelected() {
//        getHomePage().clickOnDocumentationButton();
//        getDocumentationPage().clickOnPythonTab();
//        getDocumentationPage().waitVisibilityOfElement(30, By.xpath(getDocumentationPage().getPythonCode()));
//        assertTrue(getDocumentationPage().isPythonTabSelected());
//    }
//
//    @Test(priority = 3)
//    public void checkThatCSharpTabSelected() {
//        getHomePage().clickOnDocumentationButton();
//        getDocumentationPage().clickOnCSharpTab();
//       // getDocumentationPage().waitVisibilityOfElement(30, By.xpath(getDocumentationPage().getCsharpCode()));
//        $$(getDocumentationPage().getCsharpCode()).shouldHave(CollectionCondition.itemWithText("using"));
//    //    assertTrue(getDocumentationPage().isCSharpTabSelected());
//    }
//
//    @Test(priority = 4)
//    public void checkThatRubyTabSelected() {
//        getHomePage().clickOnDocumentationButton();
//        getDocumentationPage().clickOnRubyTab();
//        getDocumentationPage().waitVisibilityOfElement(30, By.xpath(getDocumentationPage().getRubyCode()));
//        assertTrue(getDocumentationPage().isRubyTabSelected());
//    }
//
//    @Test(priority = 5)
//    public void checkThatJavaScriptTabSelected() {
//        getHomePage().clickOnDocumentationButton();
//        getDocumentationPage().clickOnJavaScriptTab();
//        getDocumentationPage().waitVisibilityOfElement(30, By.xpath(getDocumentationPage().getJavaScriptCode()));
//        assertTrue(getDocumentationPage().isJavaScriptTabSelected());
//    }
//
//    @Test(priority = 6)
//    public void checkThatKotlinTabSelected() {
//        getHomePage().clickOnDocumentationButton();
//        getDocumentationPage().clickOnKotlinTab();
//        getDocumentationPage().waitVisibilityOfElement(60, By.xpath(getDocumentationPage().getKotlinCode()));
//        assertTrue(getDocumentationPage().isKotlinTabSelected());
//    }

}
