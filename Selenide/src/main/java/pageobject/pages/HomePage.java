package pageobject.pages;


import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private static final String DOCUMENTATION_BUTTON = "//a[@href='/documentation']";
//    public HomePage(WebDriver driver) {
//        super(driver);
//    }

    public void clickOnDocumentationButton() {
        $(By.xpath(DOCUMENTATION_BUTTON)).click();
    }

}
