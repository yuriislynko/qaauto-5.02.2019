package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class ResetPasswordLinkPage {
    private WebDriver driver;

    @FindBy(xpath = "//form[@id='sendemail-form']")
    private WebElement sendEmailForm;

    public ResetPasswordLinkPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return sendEmailForm.isDisplayed()
                && driver.getCurrentUrl().contains("/request-password-reset-submit");
                /*&& driver.getTitle().contains("Please check your mail for reset password link.  | LinkedIn");*/
                //&& driver.getTitle().contains("Please check your mail for reset password link");
    }

    public ChooseNewPasswordPage getResetLink (String resetLink) {
        /*try {
            sleep(180000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        driver.get(resetLink);
        return new ChooseNewPasswordPage(driver);
    }
}


