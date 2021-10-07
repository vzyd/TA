package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;


public class SignUpPage extends BasePage{
    public SignUpPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "#email")
    WebElement inputEmailField;

    @FindBy(xpath = "//div[@id='email-container']//button[contains(@class, 'signup-continue-button')]")
    WebElement inputEmailContinueButton;

    @FindBy(css = "#email-err")
    WebElement emailErrMessage;

    @FindBy(css = "#password")
    WebElement inputPasswordField;

    @FindBy(xpath = "//p[@id='password-err']//p[contains(text(), 'short')]")
    WebElement shortPasswordMessage;

    @FindBy(xpath = "//p[@id='password-err']//p[contains(text(), 'lowercase letter')]")
    WebElement needLowercasePassMessage;

    @FindBy(xpath = "//p[@id='password-err']//span[contains(text(), 'at least 15')]")
    WebElement howMuchCharPassMassage;


    public void enterEmail(String userEmail){
        inputEmailField.clear();
        inputEmailField.sendKeys(userEmail);

    }

    public void clickOnContinueButton(){
        inputEmailContinueButton.click();
    }

    public String getEmailErrorText(){
        return emailErrMessage.getText();
    }

    public WebElement getInputEmailField() {
        return inputEmailField;
    }

    public WebElement getEmailErrMessage() {
        return emailErrMessage;
    }


    public void enterPassword(String password){
        inputPasswordField.clear();
        inputPasswordField.sendKeys(password);
    }

    public WebElement getInputPasswordField() {
        return inputPasswordField;
    }

    public WebElement getShortPasswordMessage() {
        return shortPasswordMessage;
    }

    public WebElement getHowMuchCharPassMassage() {
        return howMuchCharPassMassage;
    }

    public String getColorShortPasswordMessage(){
        return shortPasswordMessage.getCssValue("color");
    }

    public String getColorHowMuchCharPassMassage(){
        return howMuchCharPassMassage.getCssValue("color");
    }

    public String getColorNeedLowercasePassMessage(){
        return needLowercasePassMessage.getCssValue("color");
    }

    public WebElement getInputEmailContinueButton() {
        return inputEmailContinueButton;
    }

    public String getColorEmailErrMessage(){
        return emailErrMessage.getCssValue("color");
    }
}
