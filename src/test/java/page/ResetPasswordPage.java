package page;

import org.apache.commons.exec.util.StringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

import java.security.Key;

import static java.lang.Thread.sleep;

public class ResetPasswordPage {
    private WebDriver driver;

    @FindBy(xpath = "//form[@id='reset-password-form']")
    private WebElement resetPasswordForm;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement inputUsername;

    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return resetPasswordForm.isDisplayed()
                //&& driver.getCurrentUrl().contains("/forgot-password")
                && driver.getTitle().contains("Reset Password | LinkedIn");
    }

    public ResetPasswordLinkPage enterEmail (String userEmail) {
        inputUsername.sendKeys(userEmail);

        String messageSubject = "here's the link to reset your password";
        String messageTo = userEmail;
        String messageFrom = "security-noreply@linkedin.com";

        GMailService gMailService = new GMailService();
        gMailService.connect();
        inputUsername.sendKeys(Keys.ENTER);

        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 180);
        System.out.println("Content: " + message);


        /*try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return new ResetPasswordLinkPage(driver, message);


    }

}
