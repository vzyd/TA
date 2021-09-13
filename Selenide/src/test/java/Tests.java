import com.codeborne.selenide.CollectionCondition;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DocumentationPage;
import pages.HomePage;

import static com.codeborne.selenide.Selenide.open;


public class Tests {


    @BeforeMethod
    public void testsSetUp() {
        open("https://www.selenium.dev/");
        new HomePage().clickOnDocumentationButton();

    }


    @Test(priority = 1)
    public void checkThatJavaTabSelected() {
        DocumentationPage documentationPage = new DocumentationPage();
        documentationPage.clickOnJavaTab();
        documentationPage.getJavaCode().shouldHave(CollectionCondition.containExactTextsCaseSensitive("public", "HelloSelenium"));
    }


    @Test(priority = 2)
    public void checkThatPythonTabSelected() {
        DocumentationPage documentationPage = new DocumentationPage();
        documentationPage.clickOnPythonTab();
        documentationPage.getPythonCode().shouldHave(CollectionCondition.containExactTextsCaseSensitive("from", "print"));
    }

    @Test(priority = 3)
    public void checkThatCSharpTabSelected() {
        DocumentationPage documentationPage = new DocumentationPage();
        documentationPage.clickOnCSharpTab();
        documentationPage.getCsharpCode().shouldHave(CollectionCondition.containExactTextsCaseSensitive("using", "IWebElement"));
    }

    @Test(priority = 4)
    public void checkThatRubyTabSelected() {
        DocumentationPage documentationPage = new DocumentationPage();
        documentationPage.clickOnRubyTab();
        documentationPage.getRubyCode().shouldHave(CollectionCondition.containExactTextsCaseSensitive("require", "begin", "ensure"));
    }

    @Test(priority = 5)
    public void checkThatJavaScriptTabSelected() {
        DocumentationPage documentationPage = new DocumentationPage();
        documentationPage.clickOnJavaScriptTab();
        documentationPage.getJavaScriptCode().shouldHave(CollectionCondition.containExactTextsCaseSensitive("async", "await", "let"));
    }

    @Test(priority = 6)
    public void checkThatKotlinTabSelected() {
        DocumentationPage documentationPage = new DocumentationPage();
        documentationPage.clickOnKotlinTab();
        documentationPage.getKotlinCode().shouldHave(CollectionCondition.containExactTextsCaseSensitive("fun", "println"));
    }

}
