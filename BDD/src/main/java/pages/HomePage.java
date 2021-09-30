package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

//    @FindBy(css = "#user_email")
//    WebElement emailEntryField;

    @FindBy(xpath = "//button[contains(@data-hydro-click, 'Sign up')]")
    WebElement signUpButton;

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void clickOnSignUpButton(){
        signUpButton.click();
    }

//    public void enterEmail(String userEmail){
//        emailEntryField.clear();
//        emailEntryField.sendKeys(userEmail, Keys.ENTER);
//    }

//    public Alert getAlertMessage(){
//        return driver.switchTo().alert();
//    }
}
