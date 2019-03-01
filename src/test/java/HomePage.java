import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    @FindBy(xpath = "//li[@id='profile-nav-item']")
    private WebElement profileMenuItem;

    public HomePage (WebDriver driverFromTest) {
        this.driver = driverFromTest;
        PageFactory.initElements(driver, this);
    }

    /*private void initElement (){
        profileMenuItem = driver.findElement(By.xpath("//li[@id='profile-nav-item']"));
    }*/

    public boolean isProfileMenuItemDisplayed (){
        return profileMenuItem.isDisplayed();
    }

    public boolean isPageLoaded() {
        return profileMenuItem.isDisplayed()
                && driver.getCurrentUrl().contains("/feed")
                && driver.getTitle().contains("LinkedIn");
    }
}
