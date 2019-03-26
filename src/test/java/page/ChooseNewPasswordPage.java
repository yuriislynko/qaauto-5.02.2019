package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChooseNewPasswordPage {
    private WebDriver driver;

    /*@FindBy(xpath = "//form[@id='confirm-password-reset-form']")
    private WebElement resetConfirmPasswordForm;*/

    @FindBy(xpath = "//input[@id='newPassword']")
    private WebElement newPasswordInput;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement submitButton;


    public ChooseNewPasswordPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return newPasswordInput.isDisplayed()
                && driver.getCurrentUrl().contains("/password-reset");
    }

    public SuccessfulPasswordResetPage changingPassword (String newPassword, String confirmPassword){
        newPasswordInput.sendKeys(newPassword);
        confirmPasswordInput.sendKeys(confirmPassword);
        submitButton.click();

        return new SuccessfulPasswordResetPage(driver);
        }

}
