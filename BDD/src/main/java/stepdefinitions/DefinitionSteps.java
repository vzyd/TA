package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.SignUpPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    HomePage homePage;
    SignUpPage signUpPage;


    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @Given("Github {string} is opened")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("user click on 'Sign up' button")
    public void clickOnSignUpButton() {
        homePage.clickOnSignUpButton();

    }

    @When("user enters {string} into email field")
    public void enterEmail(final String email) {
        signUpPage = pageFactoryManager.getSignUpPage();
        signUpPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signUpPage.getInputEmailField());
        signUpPage.enterEmail(email);
        signUpPage.waitUntilElementToBeClickable(DEFAULT_TIMEOUT, signUpPage.getInputEmailContinueButton());
        signUpPage.clickOnContinueButton();
    }

    @Then("error message below email field should be displayed")
    public void checkEmailErr() {
        String errMessage = "Email is invalid";
        signUpPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signUpPage.getEmailErrMessage());
        assertTrue(signUpPage.getEmailErrorText().contains(errMessage));
    }

    @When("user enters {string} into password field")
    public void enterPassword(String password) {
        signUpPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signUpPage.getInputPasswordField());
        signUpPage.enterPassword(password);
        signUpPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signUpPage.getHowMuchCharPassMassage());
    }

    @Then("'at least 15 characters' message should be marked light blue")
    public void checkColorHowMuchCharMassage() {
        signUpPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signUpPage.getInputPasswordField());
        String lightBlue = "rgba(98, 117, 151, 1)";
        assertEquals(lightBlue, signUpPage.getColorHowMuchCharPassMassage());
    }

    @And("'Password is too short' message should be marked red")
    public void checkColorShortPasswordMessage() {
        String red = "rgba(237, 78, 80, 1)";
        assertEquals(red, signUpPage.getColorShortPasswordMessage());
    }

    @And("'lowercase letter' message should be marked yellow")
    public void checkColorNeedLowercaseMessage(){
        String yellow = "rgba(255, 211, 61, 1)";
        assertEquals(yellow, signUpPage.getColorNeedLowercasePassMessage());
    }


    @After
    public void tearDown() {
        driver.close();
    }

}
