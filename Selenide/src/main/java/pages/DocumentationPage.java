package pages;


import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DocumentationPage {

    private static final String JAVA_TAB = "//a[@id='tabs-1-0-tab']"; //xpath locator
    private static final String PYTHON_TAB = "tabs-1-1-tab"; //id locator
    private static final String CSHARP_TAB = "[id=tabs-1-2-tab]"; //css locator
    private static final String RUBY_TAB = "[id=tabs-1-3-tab]";
    private static final String JAVA_SCRIPT_TAB = "[id=tabs-1-4-tab]";
    private static final String KOTLIN_TAB = "[id=tabs-1-5-tab]";

    // содержимое закладки сохраняем в List
    private static final ElementsCollection javaCode = $$(byXpath("//code[@class='language-Java']//span"));
    private static final ElementsCollection pythonCode = $$(byXpath("//code[@class='language-Python']//span"));
    private static final ElementsCollection csharpCode = $$(byXpath("//code[@class='language-CSharp']//span"));
    private static final ElementsCollection rubyCode = $$(byXpath("//code[@class='language-Ruby']//span"));
    private static final ElementsCollection jsCode = $$(byXpath("//code[@class='language-JavaScript']//span"));
    private static final ElementsCollection kotlinCode = $$(byXpath("//code[@class='language-Kotlin']//span"));


    public ElementsCollection getJavaCode() {
        return javaCode;
    }

    public ElementsCollection getPythonCode() {
        return pythonCode;
    }

    public ElementsCollection getCsharpCode() {
        return csharpCode;
    }

    public ElementsCollection getRubyCode() {
        return rubyCode;
    }

    public ElementsCollection getJavaScriptCode() {
        return jsCode;
    }

    public ElementsCollection getKotlinCode() {
        return kotlinCode;
    }


    // кликаем по закладкам
    public void clickOnJavaTab() {
        $(byXpath(JAVA_TAB)).click(); // find by xpath
    }

    public void clickOnPythonTab() {
        $(byId(PYTHON_TAB)).click(); // find by id
    }

    public void clickOnCSharpTab() {
        $(CSHARP_TAB).click();// find by css
    }

    public void clickOnRubyTab() {
        $(RUBY_TAB).click();
    }

    public void clickOnJavaScriptTab() {
        $(JAVA_SCRIPT_TAB).click();
    }

    public void clickOnKotlinTab() {
        $(KOTLIN_TAB).click();
    }


}
