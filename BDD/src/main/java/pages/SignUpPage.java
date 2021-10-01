package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    WebElement passwordErrMessage1;

    @FindBy(xpath = "//p[@id='password-err']//span[contains(text(), 'at least 15')]")
    WebElement passwordErrMessage2;

    public void enterEmail(String userEmail){
        inputEmailField.clear();
        inputEmailField.sendKeys(userEmail);

      //  inputEmailContinueButton.click();

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", inputEmailContinueButton);
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

    public WebElement getPasswordErrMessage1() {
        return passwordErrMessage1;
    }

    public WebElement getPasswordErrMessage2() {
        return passwordErrMessage2;
    }

    public String getColorPasswordMessage1(){
        return passwordErrMessage1.getCssValue("color");
    }

    public String getColorPasswordMessage2(){
        return passwordErrMessage2.getCssValue("color");
    }
}
