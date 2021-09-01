package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class DocumentationPage extends BasePage {

    private static final String JAVA_TAB = "//a[@id='tabs-1-0-tab']";
    private static final String PYTHON_TAB = "[id=tabs-1-1-tab]";
    private static final String CSHARP_TAB = "[id=tabs-1-2-tab]";
    private static final String RUBY_TAB = "[id=tabs-1-3-tab]";
    private static final String JAVASCRIPT_TAB = "[id=tabs-1-4-tab]";
    private static final String KOTLIN_TAB = "[id=tabs-1-4-tab]";

    private static final String JAVA_CODE = "//code[@class='language-Java']//span[contains(text(), 'java')]";
    private static final String PYTHON_CODE = "//code[@class='language-Python']//span[contains(text(), 'example')]";


    public DocumentationPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnJavaTab() {
        driver.findElement(xpath(JAVA_TAB)).click();
    }

    public String getTextFromJavaCode() {
        return driver.findElement(xpath(JAVA_CODE)).getText();
    }

    public void clickOnPythonTab() {
        driver.findElement(By.cssSelector(PYTHON_TAB)).click();
    }

    public String getTextFromPythonCode() {
        return driver.findElement(By.xpath(PYTHON_CODE)).getText();
    }

}
