package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage{
    public SignUpPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "#email")
    WebElement inputEmail;

    @FindBy(css = "#email-err")
    WebElement emailErr;

    public void enterEmail(String userEmail){
        inputEmail.clear();
        inputEmail.sendKeys(userEmail, Keys.ENTER);
    }

    public String getEmailErrorText(){
        return emailErr.getText();
    }

}
