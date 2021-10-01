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
    public void clickOnSignUpButton(){
        homePage.clickOnSignUpButton();

    }

    @When("user enters {string} into email field")
    public void enterEmail(final String email){
        signUpPage = pageFactoryManager.getSignUpPage();
        signUpPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signUpPage.getInputEmailField());
        signUpPage.enterEmail(email);
    }

    @Then("error message below email field should be displayed")
    public void checkEmailErr(){
        String errMessage = "Email is invalid";
        signUpPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signUpPage.getEmailErrMessage());
      // homePage.waitForAjaxToComplete(5);

//        WebElement emailInput = driver.findElement(By.xpath("//input[@id='user_email']"));
//        Actions builder = new Actions (driver);
//
//        builder.clickAndHold().moveToElement(emailInput);
//        builder.moveToElement(emailInput).build().perform();

        //Alert alert = homePage.getAlertMessage();

//        WebElement toolTipElement = driver.findElement(By.xpath("//input[@class='js-signup-source']"));
//       String actualTooltip = toolTipElement.getText();
//
//        String color = emailInput.getCssValue("color");
//

 //       String myWindowHandle = driver.getWindowHandle();
//
//
//
// driver.switchTo().window(myWindowHandle);
       assertTrue(signUpPage.getEmailErrorText().contains(errMessage));
    }

    @When("user enters {string} into password field")
    public void enterPassword(String password) {

        signUpPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signUpPage.getInputPasswordField());
        signUpPage.enterPassword(password);
        signUpPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signUpPage.getPasswordErrMessage2());
    }

    @Then("'at least 15 characters' message should be marked light blue")
    public void checkColorSecondMassage(){ signUpPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signUpPage.getInputPasswordField());
    String passwordErrMassage2 = "rgba(98, 117, 151, 1)";

        assertEquals(passwordErrMassage2, signUpPage.getColorPasswordMessage2());
    }

    @And("'Password is too short' message should be marked red")
    public void checkColorFirstMessage() {
        String passwordErrMassage1 = "rgba(237, 78, 80, 1)";
        assertEquals(passwordErrMassage1, signUpPage.getColorPasswordMessage1());
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
