import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    private WebElement profileMenuItem;

    public HomePage (WebDriver driverFromTest) {
        this.driver = driverFromTest;
        initElement();
    }

    private void initElement (){
        profileMenuItem = driver.findElement(By.xpath("//li[@id='profile-nav-item']"));
    }

    public boolean isProfileMenuItemDisplayed (){
        return profileMenuItem.isDisplayed();
    }

    public boolean isPageLoaded() {
        return profileMenuItem.isDisplayed()
                && driver.getCurrentUrl().contains("/feed")
                && driver.getTitle().contains("LinkedIn");
    }
}
