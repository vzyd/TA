package pages;


import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    public void clickOnDocumentationButton() {
        $(byXpath("//a[@href='/documentation']")).click();
    }

}
