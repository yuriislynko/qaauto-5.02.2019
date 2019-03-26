package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessfulPasswordResetPage {

    private WebDriver driver;

    @FindBy(xpath = "//form[@id='reset-password-confirm-form']")
    private WebElement resetPasswordConfirmForm;

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement resetPasswordSubmitButton;

    public SuccessfulPasswordResetPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return resetPasswordConfirmForm.isDisplayed()
                && driver.getCurrentUrl().contains("/password-reset-submit");
    }

    public HomePage changingPasswordConfirmation (){
        resetPasswordSubmitButton.click();
        return new HomePage(driver);
    }
}
