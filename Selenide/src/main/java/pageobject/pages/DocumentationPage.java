package pageobject.pages;


import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DocumentationPage {

    private static final String JAVA_TAB = "//a[@id='tabs-1-0-tab']"; //xpath locator
    private static final String PYTHON_TAB = "tabs-1-1-tab"; //id locator
    private static final String CSHARP_TAB = "[id=tabs-1-2-tab]"; //css locator
    private static final String RUBY_TAB = "[id=tabs-1-3-tab]";
    private static final String JAVA_SCRIPT_TAB = "[id=tabs-1-4-tab]";
    private static final String KOTLIN_TAB = "[id=tabs-1-5-tab]";

    private static final String JAVA_CODE = "//code[@class='language-Java']//span";
    private static final String PYTHON_CODE = "//code[@class='language-Python']//span";
    private static final String CSHARP_CODE = "//code[@class='language-CSharp']//span";
    private static final String RUBY_CODE = "//code[@class='language-Ruby']//span";
    private static final String JAVA_SCRIPT_CODE = "//code[@class='language-JavaScript']//span";
    private static final String KOTLIN_CODE = "//code[@class='language-Kotlin']//span";

    public String getJavaCode() {
        return JAVA_CODE;
    }

    public String getPythonCode() {
        return PYTHON_CODE;
    }

    public String getCsharpCode() {
        return CSHARP_CODE;
    }

    public String getRubyCode() {
        return RUBY_CODE;
    }

    public String getJavaScriptCode() {
        return JAVA_SCRIPT_CODE;
    }

    public String getKotlinCode() {
        return KOTLIN_CODE;
    }






//    public DocumentationPage(WebDriver driver) {
//        super(driver);
//    }

    public void clickOnJavaTab() {
        $(By.xpath(JAVA_TAB)).click(); // find by xpath
    }
//    public boolean isJavaTabSelected() {
//        return isTabSelected(JAVA_KEY_WORD, JAVA_CODE);
//    }


    public void clickOnPythonTab() {
        $(PYTHON_TAB).click(); // find by id
    }
//    public boolean isPythonTabSelected() {
//        return isTabSelected(PYTHON_KEY_WORD, PYTHON_CODE);
//    }

    public void clickOnCSharpTab() {
        $(CSHARP_TAB).click();// find by css
    }
//    public boolean isCSharpTabSelected() {
//        return isTabSelected(CSHARP_KEY_WORD, CSHARP_CODE);
//    }

    public void clickOnRubyTab() {
        $(RUBY_TAB).click();
    }
//    public boolean isRubyTabSelected() {
//        return isTabSelected(RUBY_KEY_WORD, RUBY_CODE);
//    }

    public void clickOnJavaScriptTab() {
        $(JAVA_SCRIPT_TAB).click();
    }
//    public boolean isJavaScriptTabSelected() {
//        return isTabSelected(JAVA_SCRIPT_KEY_WORD, JAVA_SCRIPT_CODE);
//    }

    public void clickOnKotlinTab() {
        $(KOTLIN_TAB).click();
    }
//    public boolean isKotlinTabSelected() {
//        return isTabSelected(KOTLIN_KEY_WORD, KOTLIN_CODE);
//    }

//    public boolean isTabSelected(String tabName, String xpath) {
//        boolean isTabSelected = false;
//        for (WebElement webelement: $$(xpath)) {
//            if (webelement.getText().contains(tabName)) {
//                isTabSelected = true;
//                break;
//            }
//        }
//        return isTabSelected;
//    }

}
