package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//button[contains(@data-hydro-click, 'Sign up')]")
    WebElement signUpButton;

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void clickOnSignUpButton(){
        signUpButton.click();
    }


}
