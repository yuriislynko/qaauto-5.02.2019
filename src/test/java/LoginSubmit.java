import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSubmit {
    private WebDriver driver;
    private WebElement loginForm;
    private WebElement userEmailValidationMessage;
    private WebElement userPasswordErrorValidationMessage;

    public LoginSubmit (WebDriver driver) {
        this.driver = driver;
        initElement();
    }

    private void initElement (){
        loginForm = driver.findElement(By.xpath("//form[@class='login__form']"));
        userEmailValidationMessage = driver.findElement(By.xpath("//div[@id='error-for-username']"));
        userPasswordErrorValidationMessage = driver.findElement(By.xpath("//div[@id='error-for-password']"));
    }

    public boolean isPageLoaded() {
        return loginForm.isDisplayed()
                && driver.getCurrentUrl().contains("/login-submit")
                && driver.getTitle().contains("Sign In to LinkedIn");
    }

    public String getUserEmailValidationText() {
        return userEmailValidationMessage.getText();
    }

    public String getUserPasswordValidationText() {
        return userPasswordErrorValidationMessage.getText();
    }
}