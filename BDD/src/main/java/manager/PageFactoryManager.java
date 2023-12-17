package manager;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.SignUpPage;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public SignUpPage getSignUpPage(){
        return new SignUpPage(driver);
    }
}
