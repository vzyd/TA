package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.*;

public class DocumentationPage extends BasePage {

    private static final String JAVA_TAB = "//a[@id='tabs-1-0-tab']";
    private static final String PYTHON_TAB = "[id=tabs-1-1-tab]";
    private static final String CSHARP_TAB = "[id=tabs-1-2-tab]";
    private static final String RUBY_TAB = "[id=tabs-1-3-tab]";
    private static final String JAVA_SCRIPT_TAB = "[id=tabs-1-4-tab]";
    private static final String KOTLIN_TAB = "[id=tabs-1-5-tab]";

    private static final String JAVA_CODE = "//code[@class='language-Java']//span";
    private static final String PYTHON_CODE = "//code[@class='language-Python']//span";
    private static final String CSHARP_CODE = "//code[@class='language-CSharp']//span";
    private static final String RUBY_CODE = "//code[@class='language-Ruby']//span";
    private static final String JAVA_SCRIPT_CODE = "//code[@class='language-JavaScript']//span";
    private static final String KOTLIN_CODE = "//code[@class='language-Kotlin']//span";

    private static final String JAVA_KEY_WORD = "public";
    private static final String PYTHON_KEY_WORD = "from";
    private static final String CSHARP_KEY_WORD = "using";
    private static final String RUBY_KEY_WORD = "begin";
    private static final String JAVA_SCRIPT_KEY_WORD = "async";
    private static final String KOTLIN_KEY_WORD = "fun";


    public DocumentationPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnJavaTab() {
        driver.findElement(xpath(JAVA_TAB)).click();
    }
    public boolean isJavaTabSelected() {
        return isTabSelected(JAVA_KEY_WORD, JAVA_CODE);
    }


    public void clickOnPythonTab() {
        driver.findElement(By.cssSelector(PYTHON_TAB)).click();
    }
    public boolean isPythonTabSelected() {
        return isTabSelected(PYTHON_KEY_WORD, PYTHON_CODE);
    }

    public void clickOnCSharpTab() {
        driver.findElement(cssSelector(CSHARP_TAB)).click();
    }
    public boolean isCSharpTabSelected() {
        return isTabSelected(CSHARP_KEY_WORD, CSHARP_CODE);
    }

    public void clickOnRubyTab() {
        driver.findElement(cssSelector(RUBY_TAB)).click();
    }
    public boolean isRubyTabSelected() {
        return isTabSelected(RUBY_KEY_WORD, RUBY_CODE);
    }

    public void clickOnJavaScriptTab() {
        driver.findElement(cssSelector(JAVA_SCRIPT_TAB)).click();
    }
    public boolean isJavaScriptTabSelected() {
        return isTabSelected(JAVA_SCRIPT_KEY_WORD, JAVA_SCRIPT_CODE);
    }

    public void clickOnKotlinTab() {
        driver.findElement(cssSelector(KOTLIN_TAB)).click();
    }
    public boolean isKotlinTabSelected() {
        return isTabSelected(KOTLIN_KEY_WORD, KOTLIN_CODE);
    }

    public boolean isTabSelected(String tabName, String xpath) {
        boolean isTabSelected = false;
        for (WebElement webelement: driver.findElements(xpath(xpath))) {
            if (webelement.getText().contains(tabName)) {
                isTabSelected = true;
                break;
            }
        }
        return isTabSelected;
    }

}
