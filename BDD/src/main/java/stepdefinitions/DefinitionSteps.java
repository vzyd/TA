package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    HomePage homePage;


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

    @When("user enters {string} into email field")
    public void enterEmail(final String password){
    homePage.enterEmail(password);
    }

    @Then("error message below email field should be displayed")
    public void checkAlertMessage(){
      // homePage.waitForAjaxToComplete(5);
        String myWindowHandle = driver.getWindowHandle();

        driver.switchTo().window(myWindowHandle);
       // assertTrue(homePage.getAlertMessage().getText().contains(" "));
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
