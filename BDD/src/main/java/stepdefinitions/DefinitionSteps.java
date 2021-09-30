package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.HomePage;
import pages.SignUpPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
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
        homePage.waitForPageLoadComplete(5);
    }

    @When("user enters {string} into email field")
    public void enterEmail(final String email){
        signUpPage = pageFactoryManager.getSignUpPage();
        signUpPage.enterEmail(email);
    }

    @Then("error message below email field should be displayed")
    public void checkEmailErr(){
        String errMessage = "Email is invalid";
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

    @After
    public void tearDown() {
        driver.close();
    }

}
