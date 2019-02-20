import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSubmit {
    WebDriver driver;

    WebElement passwordErrorMessageBlock;

    public LoginSubmit (WebDriver driver) {
        this.driver = driver;
        initElement();
    }

    public void initElement (){
        passwordErrorMessageBlock = driver.findElement(By.xpath("//div[@id='error-for-username']"));
    }

    public boolean isPageLoaded() {
        return driver.getTitle().equals("Sign In to LinkedIn")
                && driver.getCurrentUrl().contains("login-submit")
                && passwordErrorMessageBlock.isDisplayed();
    }

    /*public boolean isErrorMessageDisplayed (){
        return passwordErrorMessageBlock.isDisplayed();
    }*/
}