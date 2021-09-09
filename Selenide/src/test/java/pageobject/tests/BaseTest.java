package pageobject.tests;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import pageobject.pages.DocumentationPage;
import pageobject.pages.HomePage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTest {

  //  private WebDriver driver;
    private static final String SITE_URL = "https://www.selenium.dev/";


    @BeforeTest
    public void profileSetUp() {
        chromedriver().setup();
    }

    @BeforeMethod
    public void testsSetUp() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        open(SITE_URL);

    }

    @AfterMethod
//    public void tearDown() {
//        driver.close();
//    }
//
//    public WebDriver getDriver() {
//        return driver;
//    }

    public HomePage getHomePage() {
        return new HomePage();
    }

    public DocumentationPage getDocumentationPage() {
        return new DocumentationPage();
    }


}
