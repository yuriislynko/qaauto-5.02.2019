import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    @FindBy(xpath = "//li[@id='profile-nav-item']")
    private WebElement profileMenuItem;

    @FindBy(xpath = "//form[@id='extended-nav-search']//input")
    private WebElement searchField;

    public HomePage (WebDriver driverFromTest) {
        this.driver = driverFromTest;
        PageFactory.initElements(driver, this);
    }


    public boolean isProfileMenuItemDisplayed (){
        return profileMenuItem.isDisplayed();
    }

    public boolean isPageLoaded() {
        return profileMenuItem.isDisplayed()
                && driver.getCurrentUrl().contains("/feed")
                && driver.getTitle().contains("LinkedIn");
    }

    public SearchPage search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        return new SearchPage(driver);
    }
}
