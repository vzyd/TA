import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TvAccessoriesPage extends BasePage {
    @FindBy(xpath = "//div[@class='brand-box__title']//a[contains(@href,'televizoryi')]")
    private WebElement tvButton;

    public TvAccessoriesPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnTvButton() {
        tvButton.click();
    }
}
